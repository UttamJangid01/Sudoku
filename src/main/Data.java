package main;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Data{

    private List<List<Integer>> solveSudoku;
    private List<List<Integer>> fillSudoku;

    public Data(){
        solveSudoku = Arrays.asList(
            Arrays.asList(5,3,4, 6,7,8, 9,1,2),
            Arrays.asList(6,7,2, 1,9,5, 3,4,8),
            Arrays.asList(1,9,8, 3,4,2, 5,6,7),

            Arrays.asList(8,5,9, 7,6,1, 4,2,3),
            Arrays.asList(4,2,6, 8,5,3, 7,9,1),
            Arrays.asList(7,1,3, 9,2,4, 8,5,6),

            Arrays.asList(9,6,1, 5,3,7, 2,8,4),
            Arrays.asList(2,8,7, 4,1,9, 6,3,5),
            Arrays.asList(3,4,5, 2,8,6, 1,7,9)
        );

        fillSudoku = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(5,3,0, 0,7,0, 0,0,0)),
            new ArrayList<>(Arrays.asList(6,0,0, 1,9,5, 0,0,0)),
            new ArrayList<>(Arrays.asList(0,9,8, 0,0,0, 0,6,0)),

            new ArrayList<>(Arrays.asList(8,0,0, 0,6,0, 0,0,3)),
            new ArrayList<>(Arrays.asList(4,0,0, 8,0,3, 0,0,1)),
            new ArrayList<>(Arrays.asList(7,0,0, 0,2,0, 0,0,6)),

            new ArrayList<>(Arrays.asList(0,6,0, 0,0,0, 2,8,0)),
            new ArrayList<>(Arrays.asList(0,0,0, 4,1,9, 0,0,5)),
            new ArrayList<>(Arrays.asList(0,0,0, 0,8,0, 0,7,9))
        ));
    }

    public boolean checkUserWin(){
        for(List<Integer> row : fillSudoku){
            if(row.contains(0))
                return false;
        }
        return true;
    }

    public void setFillSudoku(int row, int col, int number){
        fillSudoku.get(row).set(col, number);
    }

    public int getSolveSudoku(int row, int col){
        return solveSudoku.get(row).get(col);
    }

    public int getFillSudoku(int row, int col){
        return fillSudoku.get(row).get(col);
    }
}
