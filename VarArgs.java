public class VarArgs {
    public static void printf(String s, Object... values){
        char [] chars=s.toCharArray();
        int i2=0;
        int i3=0;
        for (int i=0;i<chars.length;i++){
            if(chars[i]=='%'){
                try {
                Object temp=values[i2];
                    switch (chars[i + 1]) {
                        case 'd':
                        case 'D':
                            System.out.print((int) temp);
                            break;

                        case 'c':
                        case 'C':
                            System.out.print((char) temp);
                            break;

                        case 's':
                        case 'S':
                            System.out.print((String) temp);
                            break;
                    }
                    i2++;
                }catch (Exception e){

                }
                i++;
            }else{
                System.out.print(chars[i]);
            }
        }
    }

    public static void main(String[] args){
        printf("My name is %c%c%c%c%c and I am %d years old\n", 'S', 'A', 'N', 'I', 'L', 19);
        printf("My name is %s and I am %d years old. Sab %s maya hai. Aakhir mei %s ne mitti me mil jaana hai\n", "SANIL", 19, "moh", "sab");
        printf("My name is %s%d%s and I am %d years old\n", "SANIL", 19);
        printf("%d %d %d %d ", 1, 3, 2, 4, 5, 6, 7, 7);
        printf("%s > %s. Shreyans, kuch kehena hai ??", "Java", "C");
    }
}