package Control;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hassan.OnDepartmentClick;
import com.example.hassan.R;

import java.util.List;

import Model.DepartmentModel;

public class DepartmentsAdapter extends RecyclerView.Adapter<DepartmentsAdapter.DepartsViewHolder> {

    //TODO : ( Updates On The Adapter)
    // 1 - we don't need Layout inflater object ( مرة واحدة فقط ) + WE don't need the context
    // 2- I Create Method (update) to update the list and data in the recycler
    // 3- Change The Views in xml ( delete imgView and Create A new TextView and update the IDs

    //    private Context context;
//    private LayoutInflater layoutInflater;
    private List<DepartmentModel> list;
    private OnDepartmentClick onDepartmentClick ;

    public DepartmentsAdapter(/*Context context,*/ List<DepartmentModel> list) {
//        this.context = context;
        this.list = list;
//        layoutInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public DepartsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_department, parent, false);

        return new DepartsViewHolder(view , onDepartmentClick);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartsViewHolder holder, int position) {
        DepartmentModel departemet= list.get(position);
        holder.lblName.setText(departemet.getName());
//        holder.imageView.setImageResource(aqsam_model.getIamge());
        holder.lblDate.setText(departemet.getDateOfAdding());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    // this method to update data in recyclerView
    public void update(List<DepartmentModel> arrayList ){
        this.list = arrayList ;
        notifyDataSetChanged();
    }

    public void setOnDepartmentClick(OnDepartmentClick onDepartmentClick){
        this.onDepartmentClick = onDepartmentClick ;
    }

    public class DepartsViewHolder extends RecyclerView.ViewHolder {
//        private ImageView imageView;
        private TextView lblName;
        private TextView lblDate;


        public DepartsViewHolder(@NonNull View itemView , final OnDepartmentClick listener) {
            super(itemView);
            lblName = itemView.findViewById(R.id.lblDepartemetName);  // Name Of The Department
            lblDate = itemView.findViewById(R.id.lblDepartemetDate);  // Date of Creation


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        listener.onDepClick(v ,getAdapterPosition() , lblName.getText().toString());
                    }
                }
            });

        }
    }
}
