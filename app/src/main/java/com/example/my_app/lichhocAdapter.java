package com.example.my_app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.my_app.DTO.ApiResponse;
import com.example.my_app.DTO.ListPostResponseDTO;
import com.example.my_app.DTO.Schedule;

import java.util.List;

public class lichhocAdapter extends BaseAdapter {

    private  List<Schedule> chedule;

    public lichhocAdapter(List<Schedule> chedule){
        this.chedule = chedule;
    }

    @Override
    public int getCount() {
        return this.chedule.size();
    }

    @Override
    public Object getItem(int position) {
        return this.chedule.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int _i, View _view, ViewGroup _viewGroup) {
        View view = _view;
        if(view == null){
            view = View.inflate(_viewGroup.getContext(), R.layout.item_layout,null);
           TextView textRoom = view.findViewById(R.id.textRoom);
            TextView  textDay = view.findViewById(R.id.textDay);
            TextView  textTime = view.findViewById(R.id.textTime);
            TextView  textClass_name = view.findViewById(R.id.textClass_name);
            TextView  textTeacher_name = view.findViewById(R.id.textTeacher_name);
            TextView textAddress = view.findViewById(R.id.textAddress);
            ViewHolder viewHolder = new ViewHolder(textRoom,textDay,textTime,textClass_name,textTeacher_name,textAddress);
            view.setTag(viewHolder);
        }
        Schedule post =
                this.chedule.get(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
                holder.textRoom.setText(post.getRoom());
        holder.textDay.setText(post.getDay());
        holder.textTime.setText(post.getTime() + "");
        holder.textClass_name.setText(post.getClass_name());
        holder.textTeacher_name.setText(post.getTeacher_name());
        holder.textAddress.setText(post.getAddress());



        return view;
    }

private static class ViewHolder{
    final  TextView textRoom;
    final TextView textDay;
    final        TextView textTime;
    final    TextView textClass_name;
    final   TextView textTeacher_name;
    final   TextView textAddress;


    public ViewHolder(TextView textRoom, TextView textDay, TextView textTime, TextView textClass_name, TextView textTeacher_name, TextView textAddress) {
        this.textRoom = textRoom;
        this.textDay = textDay;
        this.textTime = textTime;
        this.textClass_name = textClass_name;
        this.textTeacher_name = textTeacher_name;
        this.textAddress = textAddress;
    }
}


//    private  List<ListScheduleDTO.ScheduleDT> products;
//
//    public ScheduleAdapter(List<ListScheduleDTO.ScheduleDT> products){
//        this.products = products;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//
//        ListScheduleDTO.ScheduleDT scheduleItem = this.products.get(position);
//
//        holder.textRoom.setText(scheduleItem.getRoom());
//        holder.textDay.setText(scheduleItem.getDay());
//        holder.textTime.setText(scheduleItem.getTime() + "");
//        holder.textClass_name.setText(scheduleItem.getClass_name());
//        holder.textTeacher_name.setText(scheduleItem.getTeacher_name());
//        holder.textAddress.setText(scheduleItem.getAddress());
//    }
//
//    @Override
//    public int getItemCount() {
//        return products.size();
//    }
//
//    // Override các phương thức onCreateViewHolder, onBindViewHolder, getItemCount
//    // giống như trong ví dụ trước
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        TextView textRoom;
//        TextView textDay;
//        TextView textTime;
//        TextView textClass_name;
//        TextView textTeacher_name;
//        TextView textAddress;
//
//
//
//        // Thêm các thành phần khác như time, course_name, class_name, ...
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textRoom = itemView.findViewById(R.id.textRoom);
//            textDay = itemView.findViewById(R.id.textDay);
//            textTime = itemView.findViewById(R.id.textTime);
//            textClass_name = itemView.findViewById(R.id.textClass_name);
//            textTeacher_name = itemView.findViewById(R.id.textTeacher_name);
//            textAddress = itemView.findViewById(R.id.textAddress);
//            // Khởi tạo các thành phần khác
//        }
//    }
}
