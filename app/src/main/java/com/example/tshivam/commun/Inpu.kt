package com.example.tshivam.commun

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.frag_edit.*

class  Inpu: Fragment(){

    var mContext: Update ?=null
    companion object {
        fun newInstance() = Inpu()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is Update)
        this.mContext = context
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button1.setOnClickListener {
            //editText.setText("erere")
            //Your code here

            mContext?.callback(editText.text.toString())
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_edit,container,false)
    }
}
