package tech.burdzi0.swiper

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

private const val CAPACITY = 1

class MyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val message = arguments?.getString("message")
        val url = arguments?.getString("url")

        fillImageView(view, url)
        setMessage(view, message)

        return view
    }

    private fun fillImageView(view: View, url: String?) {
        val imageView = view.findViewById<ImageView>(R.id.imageView2)

        val builder = Picasso.Builder(this.context)
        builder.listener { _, _, exception ->
            exception.printStackTrace()
        }

        builder
            .build()
            .load(url)
            .into(imageView)
    }

    private fun setMessage(view: View, message: String?) {
        val textView = view.findViewById<TextView>(R.id.text)
        textView.text = message
    }

    companion object {
        fun newInstance(message:String, url:String?): MyFragment {
            return MyFragment().apply {
                arguments = Bundle(CAPACITY).apply {
                    putString("message", message)
                    putString("url", url)
                }
            }
        }
    }

}
