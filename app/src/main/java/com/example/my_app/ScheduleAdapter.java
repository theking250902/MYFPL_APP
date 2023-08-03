package com.example.my_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_app.DTO.ListPostResponseDTO;
import com.example.my_app.DTO.Schedule;

import java.util.List;

public class ScheduleAdapter extends BaseAdapter {

    private  List<ListPostResponseDTO.PostResponseDTO> posts;

    public ScheduleAdapter(List<ListPostResponseDTO.PostResponseDTO> posts){
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return this.posts.size();
    }

    @Override
    public Object getItem(int position) {
        return this.posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int _i, View _view, ViewGroup _viewGroup) {
        View view = _view;
        if(view == null){
            view = View.inflate(_viewGroup.getContext(), R.layout.item_listview,null);
              TextView  titleTxt = view.findViewById(R.id.titleTxt);
            TextView  created_atTxt = view.findViewById(R.id.created_atTxt);
            ViewHolder viewHolder = new ViewHolder(titleTxt,created_atTxt);
            view.setTag(viewHolder);
        }
        ListPostResponseDTO.PostResponseDTO post =
                this.posts.get(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.titleTxt.setText(post.getTitle());
        holder.created_atTxt.setText(post.getCreated_at() + "");


        return view;
    }

private static class ViewHolder{
    final TextView  titleTxt;
    final TextView  created_atTxt;

    public ViewHolder(TextView titleTxt, TextView created_atTxt) {
        this.titleTxt = titleTxt;
        this.created_atTxt = created_atTxt;


    }
}


//    private  List<Schedule.ScheduleDT> products;
//
//    public ScheduleAdapter(List<Schedule.ScheduleDT> products){
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
//        Schedule.ScheduleDT scheduleItem = this.products.get(position);
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
