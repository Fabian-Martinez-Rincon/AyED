package practica1.src;

public class cinco {
    public static int[] incisoA(int[] arreglo) {
        
        int[] array = new int[3];
        array[0] = -1; //Para calcular Maximo
        array[1] = 9999;    //Para calcular minimo
        array[2] = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i]>array[0]){
                array[0] = arreglo[i];  //Calculo el maximo en array[0]
            }
            if(arreglo[i]<array[1]){
                array[1] =  arreglo[i]; //Calculo el minimo en arra[1]
            }
            array[2]=array[2]+arreglo[i];   //Calculo el total en array[2]
        }
        array[2]=array[2]/arreglo.length;//Total/cantidad de elementos
        return array;
    }
    public static void MetodoB(IncisoB objetoB, int[] arreglo) {
        objetoB.setMax(-1);
        objetoB.setMin(9999);
        objetoB.setProm(0);

        for (int i=0; i<arreglo.length;i++){
            if(arreglo[i]>objetoB.getMax()){
                objetoB.setMax(arreglo[i]);
            }
            if(arreglo[i]>objetoB.getMin()){
                objetoB.setMin(arreglo[i]);
            }
            objetoB.setProm(objetoB.getProm()+arreglo[i]);
        }
        objetoB.setProm(objetoB.getProm()/arreglo.length);
    }
    public static void main(String[] args) {
        int[] arreglo = {1,2,3,4};
        int[] arregloA= new int[3];
        arregloA = incisoA(arreglo);
        for(int i=0; i<3;i++) {
			System.out.println(arregloA[i]);
		}

        IncisoB ObjetoB = new IncisoB();
        MetodoB(ObjetoB,arreglo);
        System.out.println(ObjetoB.toString());
    }
}
