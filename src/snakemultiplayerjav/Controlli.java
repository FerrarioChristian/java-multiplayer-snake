package snakemultiplayerjav;



public class Controlli {
        
   static boolean controllaPsw(String s){
       boolean a = true;   //psw corretta 
       int i = s.length(); 
       //controlla se la password è lunga almeno 8 caratteri
       if(i<8){
           a=false;     //se non lo è imposta false  
       }
       //se la password è lunga almeno 8 caratteri fa il 2o controllo
       if(a==true){           
            int b;
            a = false;    //imposto la correttezza della password a false           
            for(b=0;b<i;b++){
                int cc= s.charAt(b);
                if(cc>64&&cc<91)
                   a=true;   //se la password contiene almeno una maiuscola, viene impostata la correttezza true
            }
       }       
       return a;
   }
   
   static boolean controllaEmail(String s){
       boolean a= false;   //Email sbagliata
       int b = s.indexOf('@'); //controllo se nella mail è presente la @
       if(b!=-1) 
           a= true;   //se nella mail è presente la @ imposto la password a corretta
       //se la password è corretta entra nel controllo sulla presenza del punto dopo la @
       if(a==true){
           
            a=false; //imposto la correttezza della mail a false
            for(;b<s.length();b++){
                if(s.indexOf('.')!=-1)
                    a=true; //se è presente un punto la mail è corretta
            }
       }
       return a;
   }
}