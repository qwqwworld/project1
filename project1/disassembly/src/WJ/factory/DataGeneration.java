package WJ.factory;


public class DataGeneration {

    public static int dataTransfer(String str){

        int result;
        if(str.charAt(0)=='1'){
            String substring = str.substring(1, 32);
            int integer = Integer.valueOf(substring, 2);
            result=-2147483648+integer;
        }else{
            result= Integer.valueOf(str,2);
        }
        return result;
    }
}
