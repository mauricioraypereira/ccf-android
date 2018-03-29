package thiagocury.eti.br.ccf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mauriciormp on 18/02/2016.
 */
public class ClienteAdapterFiltro extends BaseAdapter{

    private Context context;

    private ArrayList<Cliente> listaCliente;
    private LayoutInflater inflater;

    /*Buscando referencias dos objetos relacionados ao
    * layout da linha(row) do listView*/
    public TextView tvIdCliente;
    public TextView tvNomeCompleto;
    public TextView tvCpf;
    public TextView tvEndereco;
    public TextView tvNumero;
    public TextView tvBairro;
    public TextView tvCidade;
    public TextView tvUf;
    public TextView tvCep;
    public TextView tvTelefoneFixo;
    public TextView tvTelefoneCelular;
    public TextView tvEmail;


    public ClienteAdapterFiltro(Context context, ArrayList<Cliente> listaCliente ){
        this.context = context;
        this.listaCliente = listaCliente;

        inflater = LayoutInflater.from(context);
    }//fecha construtor

    //Chamar no muke \o/
    public void notifyDataSetChanged(){

        try{
            super.notifyDataSetChanged();
        }catch(Exception e){
            trace("Erro: " + e.getMessage());
        }

    }//fecha notifyDataSetChanged

    //métodos responsaveis pelo envio de mensagens
    public void toast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }//fecha toast

    private void trace(String msg){
        toast(msg);
    }//fecha trace

    public void add(Cliente cli){
        listaCliente.add(cli);
    }//fecha add

    public void remove(Cliente cli){
        listaCliente.remove(cli);
    }//fecha remove

    public int getCount(){
        //no braçoviski
        return listaCliente.size();
    }//gecha getCount

    public Cliente getItem(int position){
        //no braço
        return listaCliente.get(position);
    }//fecha getItem

    public long getItemId(int position){
        //fazer no braço
        return position;
    }//fecha getItemId

    public View getView(int position, View converView, ViewGroup parent){

        try{

            Cliente cli = listaCliente.get(position);

            if(converView == null){

                converView = inflater.inflate(R.layout.list_cliente, null);

            }

            //instancias dos objetos da linha
            //guarda a referencia dos objetos
            tvIdCliente = (TextView) converView.findViewById(R.id.tvIdCliente);
            tvNomeCompleto = (TextView) converView.findViewById(R.id.tvNomeCompleto);
            tvCpf = (TextView) converView.findViewById(R.id.tvCpf);
            tvEndereco = (TextView) converView.findViewById(R.id.tvEndereco);
            tvNumero = (TextView) converView.findViewById(R.id.tvNumero);
            tvBairro = (TextView) converView.findViewById(R.id.tvBairro);
            tvCidade = (TextView) converView.findViewById(R.id.tvCidade);
            tvUf = (TextView) converView.findViewById(R.id.tvUf);
            tvCep = (TextView) converView.findViewById(R.id.tvCep);
            tvTelefoneFixo = (TextView) converView.findViewById(R.id.tvTelefoneFixo);
            tvTelefoneCelular = (TextView) converView.findViewById(R.id.tvTelefoneCelular);
            tvEmail = (TextView) converView.findViewById(R.id.tvEmail);

            //setando o cliente na respectiva linha
            tvIdCliente.setText("Código: " + cli.getIdcliente());
            tvNomeCompleto.setText("Nome: " + cli.getNome());
            tvCpf.setText("Cpf: " + cli.getCpf());
            tvEndereco.setText("Endereço: " + cli.getEndereco());
            tvNumero.setText("Número: " + cli.getNumeroendereco());
            tvBairro.setText("Bairro: " + cli.getBairro());
            tvCidade.setText("Cidade: " + cli.getCidade());
            tvUf.setText("UF: " + cli.getUf());
            tvCep.setText("Cep: " + cli.getCep());
            tvTelefoneFixo.setText("Telefone Fixo: " + cli.getTelefonefixo());
            tvTelefoneCelular.setText("Telefone Celular: " + cli.getTelefonecelular());
            tvEmail.setText("Email: " + cli.getEmail());

            return converView;

        }catch(Exception e){
            trace("Erro ta dando aqui : " + e.getLocalizedMessage());
        }//fecha catch

        return converView;

    }//fecha getView


}
