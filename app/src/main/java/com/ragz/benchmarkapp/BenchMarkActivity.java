package com.ragz.benchmarkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class BenchMarkActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private EditText etGetArray;
    private TextView tvArrGen;
    private GridLayout glVisible;
    private Button btnGenerateArr;
    private Button btnBS;
    private Button btnSS;
    private Button btnMS;
    private Button btnQS;
    private Button btnIS;
    private Button btnHS;
    private Button btnBALL;
    private RadioButton rBtn;
    private TextView tvBsort;
    private TextView tvSsort;
    private TextView tvMsort;
    private TextView tvQsort;
    private TextView tvIsort;
    private TextView tvHsort;
    private int[] array;
    private int[] CloneArr;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getBaseContext(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etGetArray = (EditText) findViewById(R.id.etArraySize);
        tvArrGen = (TextView) findViewById(R.id.tvArrGenResult);
        radioGroup = (RadioGroup) findViewById(R.id.rgComplexity);
        btnGenerateArr = (Button) findViewById(R.id.btnGenerateArr);
        btnBS = (Button) findViewById(R.id.btnBubble);
        btnSS = (Button) findViewById(R.id.btnSelection);
        btnIS = (Button) findViewById(R.id.btnInsertion);
        btnHS = (Button) findViewById(R.id.btnHeap);
        btnMS = (Button) findViewById(R.id.btnMerge);
        btnQS = (Button) findViewById(R.id.btnQuick);
        btnBALL = (Button) findViewById(R.id.btnBenchMarkAll);
        tvBsort = (TextView) findViewById(R.id.tvBsortMs);
        tvSsort = (TextView) findViewById(R.id.tvSsortMs);
        tvMsort = (TextView) findViewById(R.id.tvMsortMs);
        tvQsort = (TextView) findViewById(R.id.tvQsortMs);
        tvIsort = (TextView) findViewById(R.id.tvIsortMs);
        tvHsort = (TextView) findViewById(R.id.tvHsortMs);
        glVisible = (GridLayout) findViewById(R.id.gvSort);


        btnGenerateArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int arraySize = 0;

                try {
                    arraySize = Integer.parseInt(etGetArray.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(getBaseContext(), "Enter a number please", Toast.LENGTH_SHORT).show();
                    tvArrGen.setText("");
                }

                int radioID = radioGroup.getCheckedRadioButtonId();
                rBtn = (RadioButton) findViewById(radioID);
                String caseValues = rBtn.getText().toString();

                if (arraySize != 0) {
                    switch (caseValues) {
                        case ("Best Case"):
                            tvArrGen.setText("Best case");
                            array = bestCase(arraySize);
                            tvArrGen.setText("Best Case of size " + arraySize);
                            break;
                        case ("Average Case"):
                            tvArrGen.setText("Average Case");
                            array = averageCase(arraySize);
                            tvArrGen.setText("Average Case of size " + arraySize);
                            break;
                        case ("Worst Case"):
                            tvArrGen.setText("WorstCase");
                            array = worstCase(arraySize);
                            tvArrGen.setText("Worst Case of size " + arraySize);
                            break;
                    }
                }
                if (arraySize != 0) {
                    glVisible.setVisibility(GridLayout.VISIBLE);
                    btnBALL.setVisibility(Button.VISIBLE);

                    setEnable();
                }
                setText();
            }
        });

    }

    public void setText() {
        tvBsort.setText("BS");
        tvHsort.setText("HS");
        tvQsort.setText("QS");
        tvSsort.setText("SS");
        tvIsort.setText("IS");
        tvMsort.setText("MS");
    }

    public void setEnable() {
        btnBALL.setEnabled(true);
        btnBS.setEnabled(true);
        btnMS.setEnabled(true);
        btnQS.setEnabled(true);
        btnIS.setEnabled(true);
        btnSS.setEnabled(true);
        btnHS.setEnabled(true);
    }

    public void bubSorting(View view) {
        CloneArr = array.clone();
        long start = System.currentTimeMillis();
        bubbleSort(CloneArr);
        long end = System.currentTimeMillis();
        long result = end - start;
        tvBsort.setText("" + result);

        //btnGenerateArr.setEnabled(false);
        btnBALL.setEnabled(false);
        btnBS.setEnabled(false);
        btnMS.setEnabled(false);
        btnQS.setEnabled(false);
        btnIS.setEnabled(false);
        btnSS.setEnabled(false);
        btnHS.setEnabled(false);
    }

    public void selSorting(View view) {
        CloneArr = array.clone();
        long start = System.currentTimeMillis();
        selectionSort(CloneArr);
        long end = System.currentTimeMillis();
        long result = end - start;
        tvSsort.setText("" + result);
        btnBALL.setEnabled(false);
        btnBS.setEnabled(false);
        btnMS.setEnabled(false);
        btnQS.setEnabled(false);
        btnIS.setEnabled(false);
        btnSS.setEnabled(false);
        btnHS.setEnabled(false);
    }

    public void merSorting(View view) {
        CloneArr = array.clone();
        long start = System.currentTimeMillis();
        mergeSort(CloneArr);
        long end = System.currentTimeMillis();
        long result = end - start;
        tvMsort.setText("" + result);
        btnBALL.setEnabled(false);
        btnBS.setEnabled(false);
        btnMS.setEnabled(false);
        btnQS.setEnabled(false);
        btnIS.setEnabled(false);
        btnSS.setEnabled(false);
        btnHS.setEnabled(false);
    }

    public void qukSorting(View view) {
        CloneArr = array.clone();
        long start = System.currentTimeMillis();
        quick(CloneArr);
        long end = System.currentTimeMillis();
        long result = end - start;
        tvQsort.setText("" + result);
        btnBALL.setEnabled(false);
        btnBS.setEnabled(false);
        btnMS.setEnabled(false);
        btnQS.setEnabled(false);
        btnIS.setEnabled(false);
        btnSS.setEnabled(false);
        btnHS.setEnabled(false);
    }

    public void insSorting(View view) {
        CloneArr = array.clone();
        long start = System.currentTimeMillis();
        insertion(CloneArr);
        long end = System.currentTimeMillis();
        long result = end - start;
        tvIsort.setText("" + result);
        btnBALL.setEnabled(false);
        btnBS.setEnabled(false);
        btnMS.setEnabled(false);
        btnQS.setEnabled(false);
        btnIS.setEnabled(false);
        btnSS.setEnabled(false);
        btnHS.setEnabled(false);
    }

    public void heapSorting(View view) {
        CloneArr = array.clone();
        long start = System.currentTimeMillis();
        heap(CloneArr);
        long end = System.currentTimeMillis();
        long result = end - start;
        tvHsort.setText("" + result);
        btnBALL.setEnabled(false);
        btnBS.setEnabled(false);
        btnMS.setEnabled(false);
        btnQS.setEnabled(false);
        btnIS.setEnabled(false);
        btnSS.setEnabled(false);
        btnHS.setEnabled(false);
    }


    public void benchMarkAll(final View view) {
        tvArrGen.setText("hey working");
        bubSorting(view);
        selSorting(view);
        merSorting(view);
        qukSorting(view);
        insSorting(view);
        heapSorting(view);
        btnBALL.setEnabled(false);
        btnBS.setEnabled(false);
        btnMS.setEnabled(false);
        btnQS.setEnabled(false);
        btnIS.setEnabled(false);
        btnSS.setEnabled(false);
        btnHS.setEnabled(false);
    }

    public static int[] bestCase(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static int[] averageCase(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }

    public static int[] worstCase(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    public static void bubbleSort(int[] arry) {
        int swap = 0;
        int[] array = new int[arry.length];
        for (int i = 0; i < arry.length; i++) {
            array[i] = arry[i];
        }
        for (int a = 0; a < (array.length - 1); a++) {
            for (int b = 0; b < (array.length - a - 1); b++) {
                if (array[b] > array[b + 1]) /* For descending order use < */ {
                    swap = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = swap;
                }
            }
        }
    }

    public static void insertion(int[] input) {
        int temp;
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }
    }


    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }

    public static int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    public static void merge(int[] result, int[] left, int[] right) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }

    public static void quick(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int arr[], int low, int high) {
        int i = low, j = high;
        int temp;
        int pivot = arr[(low + high) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(arr, low, j);
        if (i < high)
            quickSort(arr, i, high);
    }

    static int N;

    public static void heap(int arr[]) {
        heapify(arr);
        for (int i = N; i > 0; i--) {
            swapNumbers(0, i, arr);
            N = N - 1;
            maxheap(arr, 0);
        }
    }

    public static void heapify(int arr[]) {
        N = arr.length - 1;
        for (int i = N / 2; i >= 0; i--)
            maxheap(arr, i);
    }

    public static void maxheap(int arr[], int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])
            max = right;

        if (max != i) {
            swapNumbers(i, max, arr);
            maxheap(arr, max);
        }
    }

    private static void swapNumbers(int i, int j, int[] array) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
