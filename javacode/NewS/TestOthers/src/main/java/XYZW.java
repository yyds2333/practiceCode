public class XYZW {
    public static void main(String[] args) {
        long x = 1;
        long y = 1;
        long z = 1;
        long w = 1;
        boolean flag=true;
        long[] arr= new long[4];
        while(flag){
            for (int i = 2;;i++){
                for (int j = 2;;j++){
                    for (int k = 2;;k++){
                        for (;;w++){
                            System.out.println("四值："+i+"+"+j+"+"+k+"+"+w);
                            if ((i*i*i*i+j*j*j*j+k*k*k*k)==(w*w*w*w)){
                                x=arr[0]=i;
                                y=arr[1]=j;
                                z=arr[2]=k;
                                arr[3]=w;
                                flag=false;
                            }
                            if ((i*i*i*i+j*j*j*j+k*k*k*k)<(w*w*w*w))break;
                        }
                        if (k/j>10)break;
                    }
                    if (j/i>10)break;
                }
            }
        }
        System.out.println(x+"⁴+"+y+"⁴+"+z+"⁴+"+"="+w+"⁴");
    }
}
