package com.jinncyapps.authenapp.bindingAdapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.jinncyapps.authenapp.activities.elicitation.fragments.ClientNetworkStatus
import com.todkars.shimmer.ShimmerRecyclerView

@BindingAdapter("recyclerStatus")
fun bindStatus(recycler: ShimmerRecyclerView, status: ClientNetworkStatus){
   when (status) {
       ClientNetworkStatus.LOADING -> {
            recycler.showShimmer()
       }
       ClientNetworkStatus.DONE -> {
           recycler.hideShimmer()

       }
       ClientNetworkStatus.ERROR -> {
           recycler.hideShimmer()
       }
   }
}
@BindingAdapter("imageBind")
fun bindStatus(statusImage: ImageView, status: ClientNetworkStatus){
   when (status) {
       ClientNetworkStatus.LOADING -> {

       }
       ClientNetworkStatus.DONE -> {


       }
       ClientNetworkStatus.ERROR -> {

       }
   }
}