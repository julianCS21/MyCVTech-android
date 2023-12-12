package mycvtech.main.network.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mycvtech.main.network.model.Skill;
import mycvtech.main.R;

public class SoftSkillAdapter extends RecyclerView.Adapter<SoftSkillAdapter.SoftSkillViewHolder> {

    private List<Skill> softSkillsList;

    public SoftSkillAdapter(List<Skill> softSkillsList) {
        this.softSkillsList = softSkillsList;
    }

    @NonNull
    @Override
    public SoftSkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_item, parent, false);
        return new SoftSkillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoftSkillViewHolder holder, int position) {
        Skill softSkill = softSkillsList.get(position);
        holder.nameTextView.setText(softSkill.getName());
    }

    @Override
    public int getItemCount() {
        return softSkillsList.size();
    }

    public static class SoftSkillViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;

        public SoftSkillViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.soft_skill_name);
        }
    }
}
