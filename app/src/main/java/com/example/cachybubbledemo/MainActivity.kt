package com.example.cachybubbledemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity(),IncreaseSize{
    lateinit var llParent: CustomView
    lateinit var horizontalscroll: HorizontalScrollView

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llParent = findViewById(R.id.llParent)
        horizontalscroll = findViewById(R.id.horizontalscroll)
        llParent.stringList = LinkedList<String>(
            listOf(
                "Jack",
                "Adam",
                "Katherin",
                "weferwferwger",
                "wefrewferf",
                "wefewfrewrf",
                "edferfre",
                "efewf",
                "wefewfewf",
                "efewfwerf",
                "wefewfewf",
                "efwefewf",
                "dewfef",
                "efwefwrf",
                "wfewferfg",
                "fdesfesf",
                "fsfsfgr",
                "efsfrgfrg",
                "weferwgfergf",
                "efsefgwefg",
                "efefgrgerg",
                "efwergerwger",
                "wer4t",
                "wtetyery",
                "qrettery",
                "qwrwetewt",
                "qwer3r",
                "qr33w",
                "ewfweferwf",
                "wefwefewf",
                "wdewdwe",
                "yedgwedyewd",
                "deyutew",
                "uyerreyfg",
                "dyetwdwedtew",
//                "tdsycfds",
//                "fsevge",
//                "ewfgergretg",
//                "wfwefgewgerg",
//                "wefewgretert",
//                "weefewfgerf"
            )
        )
        llParent.setListners(this)

        llParent.setOnTouchListener(OnTouchListener { v, event ->

            when (event.getAction()) {
                MotionEvent.ACTION_DOWN -> {
                    val cordinate_X: Float = event.rawX
                    val cordinate_Y: Float = event.rawY
                    Log.e("ScrollValue1", horizontalscroll.scrollX.toString())
                    Log.e(
                        "ScrollValue",
                        (horizontalscroll.scrollX + cordinate_X).toInt()
                            .toString() + ":" + cordinate_Y.toInt().toString()
                    )

                    val test1 = IntArray(2)
                    llParent.getLocationInWindow(test1)
                    llParent.clickedPosition(
                        (horizontalscroll.scrollX + cordinate_X).toInt(),
                        cordinate_Y.toInt()-test1[1]
                    )
                }
                else -> {

                }
            }
            return@OnTouchListener false
        })

//        val arrayList = ArrayList<String>()//Creating an empty arraylist
//        arrayList.add("Ajay jd")//Adding object in arraylist
//        arrayList.add("Vijay cks ")
//        arrayList.add("Praknkd")
//        arrayList.add("Rohan")
//        arrayList.add("Vijay")
//        arrayList.add("Ajayd")//Adding object in arraylist
//        arrayList.add("Vijkcks ")
//        arrayList.add("Prankd")
//        arrayList.add("Rohan")
//        arrayList.add("Vijay")
//        arrayList.add("Ajay jh")//Adding object in arraylist
//        arrayList.add("ay skcks ")
//        arrayList.add("Pra nkd")
//        arrayList.add("Rohan")
//        arrayList.add("Vijay")
//        arrayList.add("Ajancokc")//Adding object in arraylist
//        arrayList.add("Vijaks ")
//        arrayList.add("Prakakd")
//        arrayList.add("Rohan")
//        arrayList.add("Vijay")
//        arrayList.add("Ajhsdjk")//Adding object in arraylist
//        arrayList.add("Vikcks ")
//        arrayList.add("Prakash nkdmndckdnckdnckld")
//        arrayList.add("Rohan")
//        arrayList.add("Vijay")
//        arrayList.add("Ajay jh")//Adding object in arraylist
//        arrayList.add("Vijay skcks ")
//        arrayList.add("Prakash nkd")
//        arrayList.add("Rohan")
//        arrayList.add("Vijay")
//        arrayList.add("Ajay jhsd")//Adding object in arraylist
//        arrayList.add("Vijay skcks ")
//        arrayList.add("Prakash nkd")
//        arrayList.add("Rohan")
//        arrayList.add("Vijay")

//        var count = 0
//        var lastCount = 0
//        var forword = true
//        var margin = 600
//        while (count<=20){
//            val childLeftPadingLinearLayout = LinearLayout(this)
//            childLeftPadingLinearLayout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//            childLeftPadingLinearLayout.orientation = LinearLayout.VERTICAL
//            val ss : LinearLayout.LayoutParams = childLeftPadingLinearLayout.layoutParams as LinearLayout.LayoutParams
//            ss.topMargin = margin
//            childLeftPadingLinearLayout.layoutParams = ss
//            childLeftPadingLinearLayout.gravity = Gravity.TOP
//            if(lastCount>=10)
//                forword = false
//            if(lastCount<=1)
//                forword = true
//            if (forword)
//                lastCount += 2
//            else lastCount -= 2
//            for (i in 1..lastCount){
//                val childViewLeftPadding: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//
//                childLeftPadingLinearLayout.addView(childViewLeftPadding)
//            }
//            count += lastCount
//            llParent.addView(childLeftPadingLinearLayout)
//            margin -= 100
//        }
//        val ss : FrameLayout.LayoutParams = llParent.layoutParams as FrameLayout.LayoutParams
//        //ss.bottomMargin = 300
//        //llParent.layoutParams=ss
//        val child1LinearLayout = LinearLayout(this)
//        val child2LinearLayout = LinearLayout(this)
//        val child3LinearLayout = LinearLayout(this)
//        val child4LinearLayout = LinearLayout(this)
//        val childRightPadingLinearLayout1 = LinearLayout(this)
//        val childRightPadingLinearLayout = LinearLayout(this)
//        val childLeftToLeftPadingLinearLayout = LinearLayout(this)
//        val childLeftPadingLinearLayout = LinearLayout(this)
//     //   childLeftPadingLinearLayout.setBackgroundColor(this.resources.getColor(android.R.color.holo_blue_dark))
//        childLeftPadingLinearLayout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//        childLeftPadingLinearLayout.orientation = LinearLayout.VERTICAL
//
//        val childViewLeftPadding: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftPadingLinearLayout.addView(childViewLeftPadding)
//        val childViewLeftPadding1: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftPadingLinearLayout.addView(childViewLeftPadding1)
//        val childViewLeftPadding2: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftPadingLinearLayout.addView(childViewLeftPadding2)
//        val childViewLeftPadding3: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftPadingLinearLayout.addView(childViewLeftPadding3)
//        val childViewLeftPadding4: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftPadingLinearLayout.addView(childViewLeftPadding4)
//        val childViewLeftPadding5: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftPadingLinearLayout.addView(childViewLeftPadding5)
//        val childViewLeftPadding6: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftPadingLinearLayout.addView(childViewLeftPadding6)
//        val childViewLeftPadding7: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftPadingLinearLayout.addView(childViewLeftPadding7)
//        val childViewLeftPadding8: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftPadingLinearLayout.addView(childViewLeftPadding8)
//       // val childView: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        val txtBubble1 : TextView = childViewLeftPadding.findViewById(R.id.txtBubbleText);
//        var rlBubble1 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftPadding.findViewById(R.id.imgBubble)
//        txtBubble1.text = "11"
//        val txtBubble2 : TextView = childViewLeftPadding1.findViewById(R.id.txtBubbleText);
//        var rlBubble2 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftPadding1.findViewById(R.id.imgBubble)
//        txtBubble2.text = "3"
//        val txtBubble3 : TextView = childViewLeftPadding2.findViewById(R.id.txtBubbleText);
//        var rlBubble3 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftPadding2.findViewById(R.id.imgBubble)
//        txtBubble3.text = "1"
//        val txtBubble4 : TextView = childViewLeftPadding3.findViewById(R.id.txtBubbleText);
//        var rlBubble4 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftPadding3.findViewById(R.id.imgBubble)
//        txtBubble4.text = "6"
//        val txtBubble5 : TextView = childViewLeftPadding4.findViewById(R.id.txtBubbleText);
//        var rlBubble5 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftPadding4.findViewById(R.id.imgBubble)
//        txtBubble5.text = "11"
//        val txtBubble6 : TextView = childViewLeftPadding5.findViewById(R.id.txtBubbleText);
//        var rlBubble6 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftPadding5.findViewById(R.id.imgBubble)
//        txtBubble6.text = "11"
//        val txtBubble7 : TextView = childViewLeftPadding4.findViewById(R.id.txtBubbleText);
//        var rlBubble7 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftPadding6.findViewById(R.id.imgBubble)
//        txtBubble7.text = "11"




     //   childLeftToLeftPadingLinearLayout.setBackgroundColor(this.resources.getColor(android.R.color.holo_blue_dark))
//        childLeftToLeftPadingLinearLayout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//        childLeftToLeftPadingLinearLayout.orientation = LinearLayout.VERTICAL
//       // childLeftPadingLinearLayout.rotation = 30.0f
//        val childViewLeftToLeftPadding: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftToLeftPadingLinearLayout.addView(childViewLeftToLeftPadding)
//        val childViewLeftToLeftPadding1: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftToLeftPadingLinearLayout.addView(childViewLeftToLeftPadding1)
//        val childViewLeftToLeftPadding2: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftToLeftPadingLinearLayout.addView(childViewLeftToLeftPadding2)
//        val childViewLeftToLeftPadding3: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftToLeftPadingLinearLayout.addView(childViewLeftToLeftPadding3)
//        val childViewLeftToLeftPadding4: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftToLeftPadingLinearLayout.addView(childViewLeftToLeftPadding4)
//        val childViewLeftToLeftPadding5: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftToLeftPadingLinearLayout.addView(childViewLeftToLeftPadding5)
//        val childViewLeftToLeftPadding6: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftToLeftPadingLinearLayout.addView(childViewLeftToLeftPadding6)
//        val childViewLeftToLeftPadding7: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childLeftToLeftPadingLinearLayout.addView(childViewLeftToLeftPadding7)
//
//        val txtBubble11 : TextView = childViewLeftToLeftPadding.findViewById(R.id.txtBubbleText);
//        var rlBubble11 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftToLeftPadding.findViewById(R.id.imgBubble)
//        txtBubble11.text = "8"
//        val txtBubble22 : TextView = childViewLeftToLeftPadding1.findViewById(R.id.txtBubbleText);
//        var rlBubble22 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftToLeftPadding1.findViewById(R.id.imgBubble)
//        txtBubble22.text = "2"
//        val txtBubble33 : TextView = childViewLeftToLeftPadding2.findViewById(R.id.txtBubbleText);
//        var rlBubble33 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftToLeftPadding2.findViewById(R.id.imgBubble)
//        txtBubble33.text = "7"
//        val txtBubble44 : TextView = childViewLeftToLeftPadding3.findViewById(R.id.txtBubbleText);
//        var rlBubble44 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftToLeftPadding3.findViewById(R.id.imgBubble)
//        txtBubble44.text = "7"
//        val txtBubble55 : TextView = childViewLeftToLeftPadding4.findViewById(R.id.txtBubbleText);
//        var rlBubble55 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftToLeftPadding4.findViewById(R.id.imgBubble)
//        txtBubble55.text = "7"
//        val txtBubble66 : TextView = childViewLeftToLeftPadding5.findViewById(R.id.txtBubbleText);
//        var rlBubble66 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftToLeftPadding5.findViewById(R.id.imgBubble)
//        txtBubble66.text = "7"
//        val txtBubble77 : TextView = childViewLeftToLeftPadding6.findViewById(R.id.txtBubbleText);
//        var rlBubble77 : com.example.cachybubbledemo.RoundedCornerLayout = childViewLeftToLeftPadding6.findViewById(R.id.imgBubble)
//        txtBubble77.text = "7"
//
//
//
//
//
//        childRightPadingLinearLayout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//        childRightPadingLinearLayout.orientation = LinearLayout.VERTICAL
//      //  childRightPadingLinearLayout.rotation = 30.0f
//        val childViewRightPadding: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childRightPadingLinearLayout.addView(childViewRightPadding)
//        val childViewRightPadding1: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childRightPadingLinearLayout.addView(childViewRightPadding1)
//        val childViewRightPadding2: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childRightPadingLinearLayout.addView(childViewRightPadding2)
//        val childViewRightPadding3: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childRightPadingLinearLayout.addView(childViewRightPadding3)
//        val childViewRightPadding4: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childRightPadingLinearLayout.addView(childViewRightPadding4)
//        val childViewRightPadding5: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childRightPadingLinearLayout.addView(childViewRightPadding5)
//        val childViewRightPadding6: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childRightPadingLinearLayout.addView(childViewRightPadding6)
//
//        val txtBubble111 : TextView = childViewRightPadding.findViewById(R.id.txtBubbleText);
//        var rlBubble111 : com.example.cachybubbledemo.RoundedCornerLayout = childViewRightPadding.findViewById(R.id.imgBubble)
//        txtBubble111.text = "9"
//        val txtBubble112 : TextView = childViewRightPadding1.findViewById(R.id.txtBubbleText);
//        var rlBubble112 : com.example.cachybubbledemo.RoundedCornerLayout = childViewRightPadding1.findViewById(R.id.imgBubble)
//        txtBubble112.text = "4"
//        val txtBubble222 : TextView = childViewRightPadding2.findViewById(R.id.txtBubbleText);
//        var rlBubble222 : com.example.cachybubbledemo.RoundedCornerLayout = childViewRightPadding2.findViewById(R.id.imgBubble)
//          txtBubble222.text = "5"
//        val txtBubble333 : TextView = childViewRightPadding3.findViewById(R.id.txtBubbleText);
//        var rlBubble333 : com.example.cachybubbledemo.RoundedCornerLayout = childViewRightPadding3.findViewById(R.id.imgBubble)
//        txtBubble333.text = "5"
//        val txtBubble444 : TextView = childViewRightPadding4.findViewById(R.id.txtBubbleText);
//        var rlBubble444 : com.example.cachybubbledemo.RoundedCornerLayout = childViewRightPadding4.findViewById(R.id.imgBubble)
//        txtBubble444.text = "5"
//        val txtBubble555 : TextView = childViewRightPadding5.findViewById(R.id.txtBubbleText);
//        var rlBubble555 : com.example.cachybubbledemo.RoundedCornerLayout = childViewRightPadding5.findViewById(R.id.imgBubble)
//        txtBubble555.text = "5"
//
//
//        childRightPadingLinearLayout1.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//        childRightPadingLinearLayout1.orientation = LinearLayout.VERTICAL
//        //  childRightPadingLinearLayout.rotation = 30.0f
//        val childViewRightPaddingg: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childRightPadingLinearLayout1.addView(childViewRightPaddingg)
//        val childViewRightPaddingg1: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childRightPadingLinearLayout1.addView(childViewRightPaddingg1)
//        val childViewRightPaddingg2: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childRightPadingLinearLayout1.addView(childViewRightPaddingg2)
//        val childViewRightPaddingg3: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childRightPadingLinearLayout1.addView(childViewRightPaddingg3)
//        val childViewRightPaddingg4: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        childRightPadingLinearLayout1.addView(childViewRightPaddingg4)
//
//
//        val txtBubble111111 : TextView = childViewRightPaddingg.findViewById(R.id.txtBubbleText);
//        var rlBubble111111 : com.example.cachybubbledemo.RoundedCornerLayout = childViewRightPaddingg.findViewById(R.id.imgBubble)
//        txtBubble111111.text = "10"
//        val txtBubble222222: TextView = childViewRightPaddingg1.findViewById(R.id.txtBubbleText);
//        var rlBubble222222 : com.example.cachybubbledemo.RoundedCornerLayout = childViewRightPaddingg1.findViewById(R.id.imgBubble)
//        txtBubble222222.text = "10"
//        val txtBubble333333 : TextView = childViewRightPaddingg2.findViewById(R.id.txtBubbleText);
//        var rlBubble333333 : com.example.cachybubbledemo.RoundedCornerLayout = childViewRightPaddingg2.findViewById(R.id.imgBubble)
//        txtBubble333333.text = "10"
//        val txtBubble44444 : TextView = childViewRightPaddingg3.findViewById(R.id.txtBubbleText);
//        var rlBubble44444 : com.example.cachybubbledemo.RoundedCornerLayout = childViewRightPaddingg3.findViewById(R.id.imgBubble)
//        txtBubble44444.text = "10"
//        val txtBubble55555 : TextView = childViewRightPaddingg4.findViewById(R.id.txtBubbleText);
//        var rlBubble55555 : com.example.cachybubbledemo.RoundedCornerLayout = childViewRightPaddingg4.findViewById(R.id.imgBubble)
//        txtBubble55555.text = "10"
//
//        child1LinearLayout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//        child1LinearLayout.orientation = LinearLayout.VERTICAL
//        //  childRightPadingLinearLayout.rotation = 30.0f
//        val child1ViewRightPadding: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child1LinearLayout.addView(child1ViewRightPadding)
//        val child1ViewRightPadding1: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//       child1LinearLayout.addView(child1ViewRightPadding1)
//        val child1ViewRightPadding2: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child1LinearLayout.addView(child1ViewRightPadding2)
//        val child1ViewRightPadding3: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child1LinearLayout.addView(child1ViewRightPadding3)
//        val child1ViewRightPadding4: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child1LinearLayout.addView(child1ViewRightPadding4)
//        val child1ViewRightPadding5: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child1LinearLayout.addView(child1ViewRightPadding5)
//        val child1ViewRightPadding6: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child1LinearLayout.addView(child1ViewRightPadding6)
//
//        val txtBubble1111111 : TextView = child1ViewRightPadding.findViewById(R.id.txtBubbleText);
//        var rlBubble1111111 : com.example.cachybubbledemo.RoundedCornerLayout = child1ViewRightPadding.findViewById(R.id.imgBubble)
//        txtBubble1111111.text = "9"
//        val txtBubble2222222 : TextView = child1ViewRightPadding1.findViewById(R.id.txtBubbleText);
//        var rlBubble2222222 : com.example.cachybubbledemo.RoundedCornerLayout = child1ViewRightPadding1.findViewById(R.id.imgBubble)
//        txtBubble2222222.text = "8"
//
//        val txtBubble3333333 : TextView = child1ViewRightPadding2.findViewById(R.id.txtBubbleText);
//        var rlBubble3333333 : com.example.cachybubbledemo.RoundedCornerLayout = child1ViewRightPadding2.findViewById(R.id.imgBubble)
//        txtBubble3333333.text = "8"
//        val txtBubble4444444 : TextView = child1ViewRightPadding3.findViewById(R.id.txtBubbleText);
//        var rlBubble4444444 : com.example.cachybubbledemo.RoundedCornerLayout = child1ViewRightPadding3.findViewById(R.id.imgBubble)
//        txtBubble4444444.text = "8"
//        val txtBubble5555555 : TextView = child1ViewRightPadding4.findViewById(R.id.txtBubbleText);
//        var rlBubble5555555 : com.example.cachybubbledemo.RoundedCornerLayout = child1ViewRightPadding4.findViewById(R.id.imgBubble)
//        txtBubble5555555.text = "8"
//
//        child2LinearLayout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//        child2LinearLayout.orientation = LinearLayout.VERTICAL
//        //  childRightPadingLinearLayout.rotation = 30.0f
//        val child2ViewRightPadding: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child2ViewRightPadding)
//        val child2ViewRightPadding1: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child2ViewRightPadding1)
//        val child2ViewRightPadding2: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child2ViewRightPadding2)
//        val child2ViewRightPadding3: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child2ViewRightPadding3)
//        val child2ViewRightPadding4: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child2ViewRightPadding4)
//        val child2ViewRightPadding5: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child2ViewRightPadding5)
//        val child2ViewRightPadding6: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child2ViewRightPadding6)
//
//
//        child3LinearLayout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//        child3LinearLayout.orientation = LinearLayout.VERTICAL
//        //  childRightPadingLinearLayout.rotation = 30.0f
//        val child3ViewRightPadding: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child3LinearLayout.addView(child3ViewRightPadding)
//        val child3ViewRightPadding1: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child3LinearLayout.addView(child3ViewRightPadding1)
//        val child3ViewRightPadding2: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child3LinearLayout.addView(child3ViewRightPadding2)
//        val child3ViewRightPadding3: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child3LinearLayout.addView(child3ViewRightPadding3)
//        val child3ViewRightPadding4: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child3LinearLayout.addView(child3ViewRightPadding4)
//        val child3ViewRightPadding5: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child3LinearLayout.addView(child3ViewRightPadding5)
//        val child3ViewRightPadding6: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child3LinearLayout.addView(child3ViewRightPadding6)
//
//
//        child2LinearLayout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
//        child2LinearLayout.orientation = LinearLayout.VERTICAL
//        //  childRightPadingLinearLayout.rotation = 30.0f
//        val child4ViewRightPadding: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child4ViewRightPadding)
//        val child4ViewRightPadding1: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child4ViewRightPadding1)
//        val child4ViewRightPadding2: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child4ViewRightPadding2)
//        val child4ViewRightPadding3: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child4ViewRightPadding3)
//        val child4ViewRightPadding4: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child4ViewRightPadding4)
//        val child4ViewRightPadding5: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child4ViewRightPadding5)
//        val child4ViewRightPadding6: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
//        child2LinearLayout.addView(child4ViewRightPadding6)

//        val sizeOfList = arrayList.size
//        var linearLayoutPipeCount = 0
//        if (sizeOfList < 50){
//            linearLayoutPipeCount = 10
//        }

        var bubbleCreated = 0
      //  var countOfArrayList : Int = 0
/*
        for (i in 0 until linearLayoutPipeCount) {
            val child = LinearLayout(this)
            child.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            child.orientation = LinearLayout.VERTICAL
            child.gravity = Gravity.CENTER
            child.rotation = 30.0f
           for (j in bubbleCreated..bubbleCreated+4) {
               if (arrayList.size != bubbleCreated){
                   val childView: View = layoutInflater.inflate(R.layout.layout_item_circle, null)
                   val txtBubble : TextView = childView.findViewById(R.id.txtBubbleText);
                   var rlBubble : com.example.cachybubbledemo.RoundedCornerLayout = childView.findViewById(R.id.imgBubble)
                   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                       txtBubble.setText(Html.fromHtml(getTenCharPerLineString(arrayList.get(j) + j + j + j + j + j + j + j + j + j + j), Html.FROM_HTML_MODE_COMPACT));
                   } else {
                       txtBubble.setText(Html.fromHtml(getTenCharPerLineString(arrayList.get(j) + j + j + j + j + j + j + j + j + j + j)))
                   }
                  // childView.layoutParams.
                   var widthOfCircle = 80
                   var heightOfCircle = 80

                 //  var countOfArrayList : Int = (j+i)
//                   if (countOfArrayList == (-1)){
//                       countOfArrayList = 0
//                   }
                   Log.d("text", arrayList.get(bubbleCreated).toString())
                   if (arrayList.get(bubbleCreated).toString().trim().length < 10){
                        widthOfCircle = 80
                        heightOfCircle = 80
                   }else if (arrayList.get(bubbleCreated).toString().trim().length < 15){
                        widthOfCircle = 100
                        heightOfCircle = 100
                   }else if (arrayList.get(bubbleCreated).toString().trim().length < 20){
                        widthOfCircle = 120
                        heightOfCircle = 120
                   }else if (arrayList.get(bubbleCreated).toString().trim().length < 30){
                        widthOfCircle = 140
                        heightOfCircle = 140
                   }else if (arrayList.get(bubbleCreated).toString().trim().length < 40){
                        widthOfCircle = 160
                        heightOfCircle = 160
                   }
                   var  param: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(convertDpToPx(this, widthOfCircle.toFloat()).toInt(), convertDpToPx(this, heightOfCircle.toFloat()).toInt());
                   Log.d("width*******" + convertDpToPx(this, widthOfCircle.toFloat()).toInt(), "height" + convertDpToPx(this, heightOfCircle.toFloat()).toInt())
                   Log.d("widthOfCircle*******" + widthOfCircle.toString(), "heightOfCircle" + heightOfCircle.toString())
                   param.setMargins(convertDpToPx(this, 5.toFloat()).toInt(), convertDpToPx(this, 5.toFloat()).toInt(), convertDpToPx(this, 5.toFloat()).toInt(), convertDpToPx(this, 5.toFloat()).toInt())
                   param.addRule(RelativeLayout.CENTER_HORIZONTAL)
                   rlBubble.layoutParams = param
                   child.addView(childView)
                   rlBubble.setOnClickListener {
                       val rnd = Random()
                       val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
                       it.setBackgroundColor(color)
                   }
                   bubbleCreated = bubbleCreated + 1
               }
           }
           // llParent.addView(child)
        }
*/
//        llParent.addView(child3LinearLayout)
//        llParent.addView(child4LinearLayout)
//        llParent.addView(child2LinearLayout)
//        llParent.addView(child1LinearLayout)
//        llParent.addView(childLeftToLeftPadingLinearLayout)
//        llParent.addView(childLeftPadingLinearLayout)
//        llParent.addView(childRightPadingLinearLayout)
//        llParent.addView(childRightPadingLinearLayout1)
//        childLeftPadingLinearLayout.visibility = View.VISIBLE
//        childRightPadingLinearLayout.visibility = View.VISIBLE

     //   scrollToView(horizontalscroll,llParent)
       // horizontalscroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
        //horizontalscroll.scrollTo(500,0)
    }


    fun scrollToView(scrollViewParent: HorizontalScrollView, view: View) {
        // Get deepChild Offset
        val handler = Handler()
        handler.postDelayed({
            val childOffset = Point()
            // Scroll to child.
            getDeepChildOffset(scrollViewParent, view.parent, view, childOffset)
            scrollViewParent.smoothScrollTo(childOffset.x, 0)
            // scroll_view.smoothScrollBy(0, 600)
        }, 200)

    }

    fun getLocation(): IntArray? {
        val test1 = IntArray(2)
        llParent.getLocationInWindow(test1)
        val test2 = IntArray(2)
        llParent.getLocationOnScreen(test2)
        return test1
    }


    private fun getDeepChildOffset(
        mainParent: ViewGroup,
        parent: ViewParent,
        child: View,
        accumulatedOffset: Point
    ) {
        val parentGroup = parent as ViewGroup
        accumulatedOffset.x += child.left
        accumulatedOffset.y += child.top
        if (parentGroup == mainParent) {
            return
        }
        getDeepChildOffset(mainParent, parentGroup.parent, parentGroup, accumulatedOffset)
    }

    fun getTenCharPerLineString(text: String): String? {
        var text = text
        var tenCharPerLineString = ""
        while (text.length > 10) {
            val buffer = text.substring(0, 10)
            tenCharPerLineString = "$tenCharPerLineString$buffer<br></br>"
            text = text.substring(10)
        }
        tenCharPerLineString = tenCharPerLineString + text.substring(0)
        return tenCharPerLineString
    }

    private fun getDPsFromPixels(context: Context, pixels: Int): Int {
        val resources = context.resources
        return (pixels / (resources.displayMetrics.densityDpi / 160f)).roundToInt()
    }
    private fun getActualDPsFromPixels(context: Context, pixels: Int): Float {
        val resources = context.resources
        return pixels / (resources.displayMetrics.densityDpi / 160f)
    }

    // extension function to convert dp to equivalent pixels
// this method return float value
    fun Int.dpToPixels(context: Context):Float = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        context.resources.displayMetrics
    )


    // extension function to convert dp to equivalent pixels
// this method return integer value
    fun Int.dpToPixelsInt(context: Context):Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        context.resources.displayMetrics
    ).toInt()

    fun convertDpToPx(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

    fun convertPxToDp(context: Context, px: Float): Float {
        return px / context.resources.displayMetrics.density
    }

    override fun increaseSize(w: Int, h: Int) {

        var width = w+w*0.05
        var height = h+h*0.05
        if ( height> this.getResources().getDisplayMetrics().heightPixels-200){
            height = (this.getResources().getDisplayMetrics().heightPixels-200).toDouble()
        }
        if(width>=this.getResources().getDisplayMetrics().widthPixels &&  height< this.getResources().getDisplayMetrics().heightPixels-200){
            width = this.getResources().getDisplayMetrics().widthPixels.toDouble()
        }

        //llParent.increaseSize(width.toInt(), height.toInt())
        var lparam = llParent.layoutParams
        lparam.height = height.toInt()
        lparam.width = width.toInt()
        llParent.layoutParams = lparam
        //llParent.invalidate()
    }

}