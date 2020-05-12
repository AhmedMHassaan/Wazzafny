package Control;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hassan.R;

import java.util.List;

import Model.JobModel;

public class MainJobAdapter extends RecyclerView.Adapter<MainJobAdapter.JobViewHolder> {
//    private LayoutInflater layoutInflater;
    private List<JobModel>list;
//    private Context context;

    public MainJobAdapter(/*Context context , */List<JobModel> list){
//        this.context = context;
        this.list = list;
//        layoutInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new JobViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jon,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        JobModel job_model = list.get(position);
        holder.lblName.setText(job_model.getName());
        holder.lblDate.setText(job_model.getAddingDate());
        holder.lblDescription.setText(job_model.getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(List<JobModel> list) {
        this.list = list ;
        notifyDataSetChanged();
    }


    public class JobViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView lblName  , lblDescription , lblDate;
        public JobViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView      = itemView.findViewById(R.id.imag_main); // Image OF Job
            lblName        = itemView.findViewById(R.id.lblJobName);  // Name Of The Job
            lblDescription = itemView.findViewById(R.id.lblJobDescription); // Description  ...
            lblDate        = itemView.findViewById(R.id.lblJobDate); // Date ...
        }
    }
}
