/**
 * 显示内容的回调函数
 *
 * 当用户单击链接时调用
 *
 * @参数 {int} page_index ：新页index
 */
function pageselectCallback(page_index) {
    //在这里面改变点击页码或者上一页/下一页时的内容,
    //分页编号是传入的page_index
    console.dir(page_index);
}

/**
 * 为分页创建option参数
 * 其实就是一个设置作用
 */
function createNewOptions() {

    //下面是一堆设定
    //设置回调函数
    var opt = {callback: pageselectCallback};
    //每页记录的条数
    opt.items_per_page = 5;
    //显示的可见的分页数
    opt.num_display_entries = 4;
    //分页链接在末尾显示的个数
    opt.num_edge_entries = 2;
    opt.prev_text = '上一页';
    opt.next_text = '下一页';
    opt.link_to = "javascript:void(0);";

    //返回这个opt即可
    return opt;
}

/** 这个函数应该是你加载页面时调用，
 * jQuery的话就是$(document).ready(init);
 */
function init(itemCounts) {

    //调用我们自己写的创建option的函数
    var optInit = createNewOptions();

    //Pagination就是html文件中分页栏的位置

    /* 参数是itemCounts是传入总的条目数，
    * 就是说，这个插件不需要你自己计算需要分多少页，
    * 只要把opt对象里的值设好就行。
    * optInit是我们创建的opt
    */
    //debugger;
    $("#Pagination").pagination(itemCounts, optInit);
}