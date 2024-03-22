//Adam Hardy
public class Project {

    public static void main(String[] args) {
        int[] magneto = {3, 54, 21, 1, 58, 87, 89, 9000, 1};
        //int[] jeanGrey = {3, 2, 5};

        long startTime = System.nanoTime();
        for(int value : magneto){
            System.out.println(value);
        }
        //BubbleSort(jeanGrey);
        //SelectionSort(magneto);
        //InsertionSort(magneto);
        MergeSort(magneto);

        System.out.println();
        for(int value : magneto){
            System.out.print(" " + value);
        }

        long elapsedNano = System.nanoTime() - startTime;
        System.out.println();
        System.out.println(elapsedNano / 1000000);
    }

    public static void BubbleSort(int[] magneto) {
        int temp;
    
        for(int i = 0; i < magneto.length - 1; i++) {
            for(int j = 0; j < magneto.length - i - 1; j++)
            //swapping
            if(magneto[j] > magneto[j + 1]) {
                temp = magneto[j];
                magneto[j] = magneto[j + 1];
                magneto[j + 1] = temp;
            }
        }
    } 

    public static void SelectionSort(int[] magneto) {
        int minIndex, temp;

        for(int i = 0; i < magneto.length - 1; i++) {
            minIndex = i; 

            for(int j = i + 1; j < magneto.length; j++){
                if(magneto[j] < magneto[minIndex])
                    minIndex = j;
            }
        
            temp = magneto[i];
            magneto[i] = magneto[minIndex] ;
            magneto[minIndex] = temp;

        }
    }
   
    public static void InsertionSort(int[] magneto) {
        int temp, j;

        for(int i = 1; i < magneto.length; i++) {
            temp = magneto[i];

            for(j = i-1; j >= 0 && magneto[j] > temp;j--) {
                //this loop will move our elements
                magneto[j+1] = magneto[j ];
            }

            magneto[j+1] = temp;
        }
    }

    public static void MergeSort(int[] magneto) {
        int length = magneto.length;

        if(length <= 1) return;

        int middle = length / 2;
        int[] quickSilver = new int[middle];
        int[] polaris = new int[length - middle];

        int l = 0; // index to keep track for our left array
        int r = 0; // index to keep track for our right array

        //populates left (quickSilver) and right (polaris) arrays
        for(; l < length; l++){
            if(l < middle) {
                quickSilver[l] = magneto[l];
            }
            else {
                polaris[r] = magneto[l];
                r++;
            }
        }

        MergeSort(quickSilver);
        MergeSort(polaris);
        Merge(quickSilver, polaris, magneto);
    } 

    public static void Merge(int[] quickSilver, int[] polaris, int[] magneto ) {
        int quickSilverSize = quickSilver.length;
        int polarisSize = polaris.length;

        int mainIndex = 0, leftMagnetoIndex = 0, rightMagnetoIndex = 0;

        if(leftMagnetoIndex < quickSilverSize && rightMagnetoIndex < polarisSize) {
            if(quickSilver[leftMagnetoIndex] < polaris[polarisSize]){
                magneto[mainIndex] = quickSilver[leftMagnetoIndex];
                mainIndex++;
                leftMagnetoIndex++;
            }
            else{
                magneto[mainIndex] = polaris[rightMagnetoIndex];
                mainIndex++;
                rightMagnetoIndex++;
            }
        }

        while (leftMagnetoIndex < quickSilverSize){
            magneto[mainIndex] = quickSilver[leftMagnetoIndex];
            mainIndex++;
            leftMagnetoIndex++;            
        }

        while (rightMagnetoIndex < polarisSize) {
            magneto[mainIndex] = polaris[rightMagnetoIndex];
            mainIndex++;
            rightMagnetoIndex++;
        }
    }
}