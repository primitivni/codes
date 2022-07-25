<?php

namespace Matrix;

use Generator;

class Matrix
{
    protected $rows;
    protected $columns;
    protected $grid = [];

    public function __construct(array $grid) {
        $this->buildFromArray(array_values($grid));
    }

    public function buildFromArray(array $grid) {
        $this->rows = count($grid);
        $columns = array_reduce(
            $grid,
            function ($carry, $value) {
                return max($carry, is_array($value) ? count($value) : 1);
            }
        );
        $this->columns = $columns;

        array_walk(
            $grid,
            function (&$value) use ($columns) {
                if (!is_array($value)) {
                    $value = [$value];
                }
                $value = array_pad(array_values($value), $columns, null);
            }
        );

        $this->grid = $grid;
    }

    public static function validateRow($row) {
        if ((!is_numeric($row)) || (intval($row) < 1)) {
            throw new Exception('Nespravny radek');
        }

        return (int)$row;
    }

    public static function validateColumn($column) {
        if ((!is_numeric($column)) || (intval($column) < 1)) {
            throw new Exception('Nespravny slupec');
        }

        return (int)$column;
    }

    protected function validateRowInRange($row) {
        $row = static::validateRow($row);
        if ($row > $this->rows) {
            throw new Exception('Pozadovany radek presahuje rozmery matice');
        }

        return $row;
    }

    protected function validateColumnInRange($column) {
        $column = static::validateColumn($column);
        if ($column > $this->columns) {
            throw new Exception('Pozadovany sloupec presahuje rozmery matice');
        }

        return $column;
    }

    public function getValue($row, $column) {
        $row = $this->validateRowInRange($row);
        $column = $this->validateColumnInRange($column);

        return $this->grid[$row - 1][$column - 1];
    }

    public function rows() {
        foreach ($this->grid as $i => $row) {
            yield $i + 1 => ($this->columns == 1)
                ? $row[0]
                : new static([$row]);
        }
    }

    public function columns() {
        for ($i = 0; $i < $this->columns; ++$i) {
            yield $i + 1 => ($this->rows == 1)
                ? $this->grid[0][$i]
                : new static(array_column($this->grid, $i));
        }
    }

    public function toArray() {
        return $this->grid;
    }

    protected static $getters = ['rows', 'columns'];

    public function __get($propertyName) {
        $propertyName = strtolower($propertyName);

        // Test for function calls
        if (in_array($propertyName, self::$getters)) {
            return $this->$propertyName;
        }

        throw new Exception('Funkce neexistuje');
    }

    protected static $functions = ['determinant'];

    public function __call($functionName, $arguments) {
        $functionName = strtolower(str_replace('_', '', $functionName));

        // Test for function calls
        if (in_array($functionName, self::$functions, true)) {
            return Functions::$functionName($this, ...$arguments);
        }
        // Test for operation calls
        if (in_array($functionName, self::$operations, true)) {
            return Operations::$functionName($this, ...$arguments);
        }
        throw new Exception('Funkce neexistuje');
    }
}
