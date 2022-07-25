<?php
namespace Matrix;
class Functions{

    //funkce pro rozdeleni matice do segmentu
    private static function getDeterminantSegment(Matrix $matrix, $row, $column) {
        $tmpMatrix = $matrix->toArray();
        unset($tmpMatrix[$row]);
        array_walk(
            $tmpMatrix,
            function (&$row) use ($column) {
                unset($row[$column]);
            }
        );

        return self::getDeterminant(new Matrix($tmpMatrix));
    }

    //funkce pro vypocet determinantu matice
    private static function getDeterminant(Matrix $matrix) {
        $dimensions = $matrix->rows;
        $determinant = 0;

        switch ($dimensions) {
            case 1:
                $determinant = $matrix->getValue(1, 1);
                break;
            case 2:
                $determinant = $matrix->getValue(1, 1) * $matrix->getValue(2, 2) - $matrix->getValue(1, 2) * $matrix->getValue(2, 1);
                break;
            default:
                for ($i = 1; $i <= $dimensions; ++$i) {
                    $det = $matrix->getValue(1, $i) * self::getDeterminantSegment($matrix, 0, $i - 1);
                    if (($i % 2) == 0) {
                        $determinant -= $det;
                    } else {
                        $determinant += $det;
                    }
                }
                break;
        }

        return $determinant;
    }

    //volani funkce pro vypocet determinantu
    public static function determinant($matrix) {
        return self::getDeterminant($matrix);
    }
}
