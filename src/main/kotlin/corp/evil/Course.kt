package corp.evil

data class Course (val id :Int,
                   val title:String="",
                   val complexity:Int =0,
                   var isActive:Boolean =false)
