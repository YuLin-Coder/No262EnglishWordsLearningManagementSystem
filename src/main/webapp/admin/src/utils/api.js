const api = {
    // 考试记录
    examrecordgroupby: 'examrecord/groupby',
    examrecordpage: 'examrecord/page',
    examrecordsave: 'examrecord/save',
    examrecorddelete: 'examrecord/delete',
    // 试卷
    exampaperpage: 'exampaper/page',
    exampaperinfo: 'exampaper/info/',
    exampapersave: 'exampaper/save',
    exampaperupdate: 'exampaper/update',
    exampaperdelete: 'exampaper/delete',
    // 试题
    examquestionpage: 'examquestion/page',
    examquestioninfo: 'examquestion/info/',
    examquestionsave: 'examquestion/save',
    examquestionupdate: 'examquestion/update',
    examquestiondelete: 'examquestion/delete',
    // 客服
    chatpage:'chat/page?sort=addtime&order=desc&isreply=1',
    chatbyuseridpage: 'chat/page?sort=addtime&order=desc&userid=',
    chatsave: 'chat/save',
    // 积分订单
    orderpage: 'orders/page',
    orderdelete: 'orders/delete',
    orderinfo: 'orders/info/',
    ordersave: 'orders/save',
    orderupdate: 'orders/update',
    // 配置
    configpage: 'config/page',
    configdelete: 'config/delete',
    configinfo: 'config/info/',
    configsave: 'config/save',
    configupdate: 'config/update'

}

export default api
