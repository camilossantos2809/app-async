package br.pucpr.async;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class EstudanteListAdapter extends RecyclerView.Adapter<EstudanteListAdapter.EstudanteViewHolder> {
    class EstudanteViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private EstudanteViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Estudante> mWords; // Cached copy of words

    EstudanteListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public EstudanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new EstudanteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EstudanteViewHolder holder, int position) {
        if (mWords != null) {
            Estudante current = mWords.get(position);
            holder.wordItemView.setText(current.getNome());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }

    void setEstudantes(List<Estudante> estudantes){
        mWords = estudantes;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }
}
