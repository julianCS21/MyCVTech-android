package mycvtech.main.network.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mycvtech.main.network.model.Expertise;
import mycvtech.main.R;

public class ExpertiseAdapter extends RecyclerView.Adapter<ExpertiseAdapter.ExpertiseViewHolder> {

    private List<Expertise> expertiseList;

    public ExpertiseAdapter(List<Expertise> expertiseList) {
        this.expertiseList = expertiseList;
    }

    @NonNull
    @Override
    public ExpertiseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expertise_item, parent, false);
        return new ExpertiseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpertiseViewHolder holder, int position) {
        Expertise expertise = expertiseList.get(position);
        holder.nameTextView.setText(expertise.getName());


        String level = expertise.getLevel();
        if (level != null) {
            holder.levelTextView.setText(level);
        } else {
            holder.levelTextView.setText("N/A");
        }
    }

    @Override
    public int getItemCount() {
        return expertiseList.size();
    }

    public static class ExpertiseViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView levelTextView;

        public ExpertiseViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.expertise_name);
            levelTextView = itemView.findViewById(R.id.expertise_level);
        }
    }
}
