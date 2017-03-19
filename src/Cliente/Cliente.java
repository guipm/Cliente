package Cliente;


import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.GregorianCalendar;

/**
 * @author guilherme Mendes
 * Data 18/03/2017
 */
public class Cliente {
        
        private String ipServidor;
        private int porta;
        private String nome;
        
/**
     *
     * @param ipServidor_
     * @param porta_
     * @throws Exception
     */
        //Iniciando a comunicação com o servidor
        public  Cliente(String ipServidor_, int porta_, String nome_)throws Exception{
           try{
               this.ipServidor = ipServidor_;       
               this.porta = porta_;
               this.nome = nome_;
               Date data = new Date(System.currentTimeMillis());
               Socket socket = new Socket (ipServidor_, porta_);
               ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
               String mensagem = entrada.readUTF();
               new ArquivoLog(data + " - " + nome_ + " - " + mensagem);
               JOptionPane.showMessageDialog(null, "conectado");
               
           }catch(HeadlessException | IOException e){ //caso haja erro de IP,porta ou servidor desligado.
               JOptionPane.showMessageDialog(null, "Erro o servidor pode estar Desligado...");
           }
        }
        //geters
        public String getIpServidor(){
            return this.ipServidor;
        }

        public int getPorta(){
            return this.porta;
        }
        //Seters
        public void setIpServidor(String ipServidor_){
            this.ipServidor = ipServidor_;
        }

        public void setPorta(int porta_) {
            this.porta = porta_;
        }

}
