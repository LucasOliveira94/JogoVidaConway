/**
 * GITHUB - LUCASOLIVEIRA94
 */

public class Game{
  
    private int x, y;
    private int i, j;
    private String pxMorto;
    private String pxVivo;
    private static String matriz[][];
    
    /*
    public Game(int x, int y){
        this.x = x;
        this.y = y;
        this.pxMorto = "0";
        this.pxVivo  = "*";
        this.matriz = new String[x][y];
    }
    */
   
    public Game(){
        this.x = 11;
        this.y = 18;
        this.pxMorto = "0";
        this.pxVivo  = "*";
        this.matriz = new String[x][y];
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setPxMorto(String m){
        this.pxMorto = m;
    }
    
    public void setPxVivo(String v){
        this.pxVivo = v;
    }
    
    public String[][] inicializar(){
        
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                if (i == 5 && (j >= 4 && j < 14)){
                    matriz[i][j] = pxVivo;
                }else{
                    matriz[i][j] = pxMorto;
                }
            }
        }
        
        //reproduzir();
        return matriz;
    }
    
    private void imprimir(){
    
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    
    }
    
    public String[][] reproduzir(){
        
        String matriz_new[][] = new String[x][y];
        
        for (i = 0; i < x; i++){
            for (j = 0; j < y; j++){
                
                if (matriz[i][j].equals(this.pxVivo)){
                    matriz_new[i][j] = testarPixels(true);
                }else{
                    matriz_new[i][j] = testarPixels(false);
                }
                
            }
        }
        
        updateMatriz(matriz_new);
        //imprimir();
        return matriz;
    }
    
    
    private String testarPixels(boolean status){
        
        int viz_v = 0;
        
        if(i == 0 && j == 0){ // TOPO ESQUEDO
            viz_v = topoEsquerdo();
        }else
        if(i == 0 && j == (y -1)){ // TOPO DIREIRO
            viz_v = topoDireito();
        }else
        if(i == (x -1) && j == 0){ // BAIXO ESQUEDO
            viz_v = baixoEsquerdo();
        }else
        if(i == (x -1) && j == (y -1)){ // BAIXO DIREITO
            viz_v = baixoDireito();
        }else
        if(i == 0 && (j != 0 && j != (y -1))){ // TOPO
            viz_v = topo();
        }else
        if(i == (x -1) && (j != 0 && j != (y -1))){ // BAIXO
            viz_v = baixo();
        }else
        if(j == 0 && (i != 0 && i != (x -1))){ // ESQUERDO
            viz_v = esquerdo();
        }else
        if(j == (y -1) && (i != 0 && i != (x -1))){ // DIREITO
            viz_v = direito();
        }else{
            viz_v = centro();
        }
        
        if (status){
            return regraVivo(viz_v);
        }else{
            return regraMorto(viz_v);
        }
        
    }
    
    private int topoEsquerdo(){
        
        int viz_v = 0;
        
        if (matriz[i][j +1].equals(pxVivo))
            viz_v++;
            
        if (matriz[i +1][j +1].equals(pxVivo))
            viz_v++;
            
        if (matriz[i +1][j].equals(pxVivo))
            viz_v++;
            
        return viz_v;
    }
    
    private int topoDireito(){
        
        int viz_v = 0;
        
        if (matriz[i][j -1].equals(pxVivo))
            viz_v++;

        if (matriz[i +1][j -1].equals(pxVivo))
            viz_v++;

        if (matriz[i +1][j].equals(pxVivo))
            viz_v++;
    
        return viz_v;
    }
    
    private int baixoEsquerdo(){
        
        int viz_v = 0;
        
        if (matriz[i -1][j].equals(pxVivo))
            viz_v++;
            
        if (matriz[i -1][j +1].equals(pxVivo))
            viz_v++;
            
        if (matriz[i][j +1].equals(pxVivo))
            viz_v++;
            
        return viz_v;
    }
    
    private int baixoDireito(){
        
        int viz_v = 0;
        
        if (matriz[i -1][j].equals(pxVivo))
            viz_v++;

        if (matriz[i -1][j -1].equals(pxVivo))
            viz_v++;

        if (matriz[i][j -1].equals(pxVivo))
            viz_v++;
    
        return viz_v;
    }
    
    private int esquerdo(){
        
        int viz_v = 0;
        
        if (matriz[i -1][j].equals(pxVivo))
            viz_v++;
            
        if (matriz[i -1][j +1].equals(pxVivo))
            viz_v++;
            
        if (matriz[i][j +1].equals(pxVivo))
            viz_v++;
        
        if (matriz[i +1][j +1].equals(pxVivo))
            viz_v++;
        
        if (matriz[i +1][j].equals(pxVivo))
            viz_v++;
            
        return viz_v;
    }
    
    private int direito(){
        
        int viz_v = 0;
        
        if (matriz[i -1][j].equals(pxVivo))
            viz_v++;
            
        if (matriz[i -1][j -1].equals(pxVivo))
            viz_v++;
            
        if (matriz[i][j -1].equals(pxVivo))
            viz_v++;
        
        if (matriz[i +1][j -1].equals(pxVivo))
            viz_v++;
        
        if (matriz[i +1][j].equals(pxVivo))
            viz_v++;
       
        return viz_v;
    }
    
    private int topo(){
        
        int viz_v = 0;
        
        if (matriz[i][j -1].equals(pxVivo))
            viz_v++;
            
        if (matriz[i +1][j -1].equals(pxVivo))
            viz_v++;
            
        if (matriz[i +1][j].equals(pxVivo))
            viz_v++;
        
        if (matriz[i +1][j +1].equals(pxVivo))
            viz_v++;
        
        if (matriz[i][j +1].equals(pxVivo))
            viz_v++;
            
        return viz_v;
    }
    
    private int baixo(){
        
        int viz_v = 0;
        
        if (matriz[i][j +1].equals(pxVivo))
            viz_v++;
            
        if (matriz[i -1][j +1].equals(pxVivo))
            viz_v++;
            
        if (matriz[i -1][j].equals(pxVivo))
            viz_v++;
        
        if (matriz[i -1][j -1].equals(pxVivo))
            viz_v++;
        
        if (matriz[i][j -1].equals(pxVivo))
            viz_v++;
       
        return viz_v;
    }
    
    private int centro(){
        
        int viz_v = 0;
        
        if (matriz[i -1][j].equals(pxVivo))
            viz_v++;
            
        if (matriz[i -1][j -1].equals(pxVivo))
            viz_v++;
            
        if (matriz[i][j -1].equals(pxVivo))
            viz_v++;
        
        if (matriz[i +1][j -1].equals(pxVivo))
            viz_v++;
        
        if (matriz[i +1][j].equals(pxVivo))
            viz_v++;
       
        if (matriz[i +1][j +1].equals(pxVivo))
            viz_v++;
        
        if (matriz[i][j +1].equals(pxVivo))
            viz_v++;
        
        if (matriz[i -1][j +1].equals(pxVivo))
            viz_v++;    
            
        return viz_v;
    }
    
    private String regraMorto(int z){
    
        return (z == 3?pxVivo:pxMorto);
    }
    
    private String regraVivo(int z){
    
        if (z < 2){
            return pxMorto;
        }else
        if (z > 3){
            return pxMorto;
        }else{
            return pxVivo;
        }
        
    }
    
    private void updateMatriz(String m[][]){
        
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                matriz[i][j] = m[i][j];
            }
        }
        
    }
}
