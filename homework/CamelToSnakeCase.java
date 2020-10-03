package homework;

/**
 * Se dă un string în formatul CamelCase (CamelCase e un format în care nu avem
 * spații, dar fiecare cuvânt începe cu literă mare, de exemplu: ParSauImpar,
 * verificăPrim, NumarDivizori, MacOS, etc.). Primul cuvânt poate să înceapă cu
 * literă mare sau mică. 
 * 
 * Să se transforme acest string în formatul Snake case
 * (Snake case un format în care toate cuvintele încep cu literă mică și
 * cuvintele sunt separate de un _ , de exemplu – pentru exemplele de mai sus:
 * par_sau_impar, verifica_prim, numar_divizori, mac_o_s)
 */
public class CamelToSnakeCase
{
    public static void main(String[] args)
    {
        System.out.println(convertCamelToSnakeCase("ParSauImpar"));
        System.out.println(convertCamelToSnakeCase("verificaPrim"));
        System.out.println(convertCamelToSnakeCase("NumarDivizori"));
        System.out.println(convertCamelToSnakeCase("MacOS"));
        System.out.println(convertCamelToSnakeCase("MacOS123"));
    }
    
    /**
     * Converts a camelCase string to its snake_case equivalent.
     * 
     * @param String camelCase
     * @return String
     */
    private static String convertCamelToSnakeCase(String camelCase) 
    {
        String snake_case = "";
        snake_case += Character.toLowerCase(camelCase.charAt(0));
        
        for (int i = 1, n = camelCase.length(); i < n; i++) {
            char currentChar = camelCase.charAt(i);
            
            if (currentChar >= 'a' && currentChar <= 'z') {
                snake_case += currentChar;
                continue;
            }
            
            if (currentChar >= 'A' && currentChar <= 'Z') {
                snake_case += '_';
                snake_case += Character.toLowerCase(currentChar);
                continue;
            }
            
            /*
             * Keep junk if any :)
             */
            snake_case += currentChar;
        }
        
        return snake_case;
    }
}
