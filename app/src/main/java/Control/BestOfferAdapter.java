package Control;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hassan.R;

import java.util.List;

import Model.JobModel;

public class BestOfferAdapter extends RecyclerView.Adapter<BestOfferAdapter.BestJobViewHolder> {
//    private LayoutInflater layoutInflater;
    private List<JobModel>list;
//    private Context context;

    public BestOfferAdapter(/*Context context , */List<JobModel> list){
//        this.context = context;
        this.list = list;
//        layoutInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public BestJobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new BestJobViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_best_offer,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BestJobViewHolder holder, int position) {
        JobModel job_model = list.get(position);
        holder.lblName.setText(job_model.getName());
        holder.lblDate.setText(job_model.getDescription());
        holder.lblDescription.setText(job_model.getAddingDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(List<JobModel> models) {
        this.list = models ;
        notifyDataSetChanged();
    }


    public class BestJobViewHolder extends RecyclerView.ViewHolder {
//        ImageView imageView;
        TextView lblName , lblDescription , lblDate ;
        public BestJobViewHolder(@NonNull View itemView) {

            super(itemView);
            lblName        = itemView.findViewById(R.id.lblJobName); // Name of the Job
            lblDescription = itemView.findViewById(R.id.lblJobDesc); // Description Of The Job
            lblDate        = itemView.findViewById(R.id.lblJobDate); // Date Of Adding the Job To DB
        }
    }
}
