package com.example.abm_products_mvp_sqlite.ABMProducts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abm_products_mvp_sqlite.R;
import com.example.abm_products_mvp_sqlite.databinding.ItemListProductBinding;
import com.example.abm_products_mvp_sqlite.pojo.Product;

import java.util.List;

/**
 * Clase de tipo Adapter que infla los valores en nuestr RecyclerView
 * @version 21/11/2021
 */

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ViewHolder> {

    //Variable List almacena objetos de clase Product
    private List<Product> productList;


    //ViewBinding referencia layout itemList
    private ItemListProductBinding listProductBinding;


    /**
     * Constructor de la clase
     * @param productList parametro de Tipo List, almacena objetos de tipo Product
     */
    public ListProductAdapter(List<Product> productList) {
        this.productList = productList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListProductAdapter.ViewHolder holder, int position) {
        holder.binData(productList.get(position));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    /**
     * metodo genera un listado nuevo
     * @param item parametro de tipo List almacena objetos de la clase Product
     */
    public void setProductList(List<Product> item){
        productList = item;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);

            listProductBinding = ItemListProductBinding.bind(itemView);

        }

        /**
         * metodo para el bind de datos con los objetos de layout
         * @param item objeto de la clase Product
         */
        void binData(final Product item){
            listProductBinding.textViewCodeProductCardView.setText(item.getProductCode());
            listProductBinding.textViewProductDescriptionCardView.setText(item.getDescription());
        }
    }
}
