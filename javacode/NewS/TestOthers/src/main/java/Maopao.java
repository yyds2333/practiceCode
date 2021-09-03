public class Maopao {
    public static void main(String[] args) {
        int[] a = {5,3,2,6,4,8,1,8,6,4,8,0};
        Maopao maopao = new Maopao();
        maopao.Maoo(a);
        maopao.Choice(a);
    }

    void Maoo(int[] a){
        int swap = 0;
        for (int i= 0 ; i < a.length -1; i++){
            for (int j = 0 ;j<a.length-i-1;j++){
                if (a[j]>a[j+1]){
                    swap = a[j];
                    a[j] = a[j+1];
                    a[j+1] = swap;
                }
            }
        }
        System.out.println("冒泡排序：");
        for(int i =  0 ;i<a.length;i++){
            System.out.print(a[i]+":");
        }
        System.out.println();
    }

    void Choice(int[] a){
        int swap=0;
        for(int i = 0;i<a.length;i++){
            for (int j = i;j<a.length-1;j++){
                if (a[i]>a[j]){
                    swap=a[i];
                    a[i]=a[j];
                    a[j]=swap;
                }
            }
        }
        System.out.println("选择排序：");
        for(int i =  0 ;i<a.length;i++){
            System.out.print(a[i]+":");
        }
    }
}
