public class Sopa
{
    public static void main (String args[]) {
        pruebas();
    }
    
    public static void pruebas() {
        int filas = 15;
        int cols = 15;
        
        char[][] sopa = new char[filas][cols] ;
        llenar(sopa, '*');
        insertarID(sopa, "camila");
        insertarID(sopa, "alessandro");
        insertarDI(sopa, "darien");
        insertarDI(sopa, "empanada");
        insertarAB(sopa, "pinto");
        insertarAB(sopa, "ucr");
        llenar(sopa);
        imprimir(sopa);
    }
    
    public static void imprimir (char[][] mat) {
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                System.out.print(" " + mat[i][j]) ;
            }
            System.out.println();
        }
    }
    
    public static void llenar (char[][] mat) {
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                if (mat[i][j] == '*') {
                    mat[i][j] = (char) ( (int) (Math.random() * 26) + 65 ) ;
                }
            }
        }
    }
    
    public static void llenar (char[][] mat, char caracter) {
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                mat[i][j] = caracter ;
            }
        }
    }
    
    public static boolean insertarID (char[][] mat, String palabra) {
        boolean cabe = true;
        if (palabra.length() <= mat[0].length ) {
            while ( ! insertarID_aux(mat, palabra) ) ;
        } else {
            cabe = false;
        }
        return cabe;
    }
    
    public static boolean insertarID_aux (char[][] mat, String palabra) {
        boolean se_puede = true;
        int fila_aleatoria = (int) (Math.random() * mat.length);
        int col_aleatoria = (int) (Math.random() * mat[fila_aleatoria].length);
        while ( col_aleatoria + palabra.length() >= mat[fila_aleatoria].length ) {
            fila_aleatoria = (int) (Math.random() * mat.length);
            col_aleatoria = (int) (Math.random() * mat[fila_aleatoria].length);
        }
        for (int i = 0; i<palabra.length(); i++) {
            if (mat[fila_aleatoria][col_aleatoria+i] != '*' && mat[fila_aleatoria][col_aleatoria+i] != palabra.charAt(i) ) {
                se_puede = false;
            }
        }
        if (se_puede) {
            for (int i = 0; i<palabra.length(); i++) {
                mat[fila_aleatoria][col_aleatoria+i] = palabra.charAt(i) ;
            }
        }
        return se_puede;
    }
    
    public static String voltear (String palabra) {
        String volteada = "";
        for (int i=palabra.length()-1; i>=0; i--) {
            volteada += palabra.charAt(i);
        }
        return volteada;
    }
    
    public static boolean insertarAB (char[][] mat, String palabra) {
        boolean cabe = true;
        if (palabra.length() <= mat.length ) {
            while ( ! insertarAB_aux(mat, palabra) ) ;
        } else {
            cabe = false;
        }
        return cabe;
    }
    
    public static boolean insertarAB_aux (char[][] mat, String palabra) {
        boolean se_puede = true;
        int fila_aleatoria = (int) (Math.random() * mat.length);
        int col_aleatoria = (int) (Math.random() * mat[fila_aleatoria].length);
        while ( fila_aleatoria + palabra.length() >= mat.length ) {
            fila_aleatoria = (int) (Math.random() * mat.length);
            col_aleatoria = (int) (Math.random() * mat[fila_aleatoria].length);
        }
        for (int i = 0; i<palabra.length(); i++) {
            if (mat[fila_aleatoria+i][col_aleatoria] != '*' && mat[fila_aleatoria+i][col_aleatoria] != palabra.charAt(i) ) {
                se_puede = false;
            }
        }
        if (se_puede) {
            for (int i = 0; i<palabra.length(); i++) {
                mat[fila_aleatoria+i][col_aleatoria] = palabra.charAt(i) ;
            }
        }
        return se_puede;
    }
    
    public static boolean insertarIDAB (char[][] mat, String palabra) {
        boolean cabe = true;
        if ( palabra.length() <= mat.length && palabra.length() <= mat[0].length ) {
            while ( ! insertarIDAB_aux(mat, palabra) ) ;
        } else {
            cabe = false;
        }
        return cabe;
    }
    
    public static boolean insertarIDAB_aux (char[][] mat, String palabra) {
        boolean se_puede = true;
        int fila_aleatoria = (int) (Math.random() * mat.length);
        int col_aleatoria = (int) (Math.random() * mat[fila_aleatoria].length);
        while ( fila_aleatoria + palabra.length() >= mat.length || col_aleatoria + palabra.length() >= mat[fila_aleatoria].length ) {
            fila_aleatoria = (int) (Math.random() * mat.length);
            col_aleatoria = (int) (Math.random() * mat[fila_aleatoria].length);
        }
        for (int i = 0; i<palabra.length(); i++) {
            if (mat[fila_aleatoria+i][col_aleatoria+i] != '*' && mat[fila_aleatoria+i][col_aleatoria+i] != palabra.charAt(i) ) {
                se_puede = false;
            }
        }
        if (se_puede) {
            for (int i = 0; i<palabra.length(); i++) {
                mat[fila_aleatoria+i][col_aleatoria+i] = palabra.charAt(i) ;
            }
        }
        return se_puede;
    }
    
    public static boolean insertarDIAB (char[][] mat, String palabra) {
        boolean cabe = true;
        if ( palabra.length() <= mat.length && palabra.length() <= mat[0].length ) {
            while ( ! insertarDIAB_aux(mat, palabra) ) ;
        } else {
            cabe = false;
        }
        return cabe;
    }
    
    public static boolean insertarDIAB_aux (char[][] mat, String palabra) {
        boolean se_puede = true;
        int fila_aleatoria = (int) (Math.random() * mat.length);
        int col_aleatoria = (int) (Math.random() * mat[fila_aleatoria].length);
        while ( fila_aleatoria + palabra.length() >= mat.length || col_aleatoria - palabra.length() +1 < 0 ) {
            fila_aleatoria = (int) (Math.random() * mat.length);
            col_aleatoria = (int) (Math.random() * mat[fila_aleatoria].length);
        }
        for (int i = 0; i<palabra.length(); i++) {
            if (mat[fila_aleatoria+i][col_aleatoria-i] != '*' && mat[fila_aleatoria+i][col_aleatoria-i] != palabra.charAt(i) ) {
                se_puede = false;
            }
        }
        if (se_puede) {
            for (int i = 0; i<palabra.length(); i++) {
                mat[fila_aleatoria+i][col_aleatoria-i] = palabra.charAt(i) ;
            }
        }
        return se_puede;
    }
    
    public static void insertarDI (char[][] mat, String palabra) {
        insertarID(mat, voltear(palabra) );
    }
    
    public static void insertarAR (char[][] mat, String palabra) {
        insertarAB(mat, voltear(palabra) );
    }
    
    public static void insertarDIAR (char[][] mat, String palabra) {
        insertarIDAB(mat, voltear(palabra) );
    }
    
}

