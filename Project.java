//Adam Hardy
public class Project {

    public static void main(String[] args) {
        int[] magneto = {3, 54, 21, 1, 58, 87, 89, 9000, 1};
        for(int value : magneto){
            System.out.println(value);
        }
        //BubbleSort(magneto);
        SelectionSort(magneto);
        System.out.println();
        for(int value : magneto){
            System.out.print(" " + value);
        }
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
    //public static void Swap() {

    //}
}