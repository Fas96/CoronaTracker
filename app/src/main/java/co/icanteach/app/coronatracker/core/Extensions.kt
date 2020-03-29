package co.icanteach.app.coronatracker.core

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide

/**
 * http://kotlinextensions.com/
 */
fun <T : ViewDataBinding> ViewGroup?.inflate(@LayoutRes layoutId: Int, attachToParent: Boolean = true): T {
    return DataBindingUtil.inflate(
        LayoutInflater.from(this!!.context),
        layoutId,
        this,
        attachToParent
    )
}

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: AppCompatImageView, url: String?) {
    Glide.with(imageView.context).load(url).into(imageView)
}

fun <T> LiveData<T>.observeNonNull(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, Observer {
        it?.let(observer)
    })
}