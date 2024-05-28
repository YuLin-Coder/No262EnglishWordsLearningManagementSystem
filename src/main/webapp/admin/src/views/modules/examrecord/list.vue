<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="!showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-form-item label="试卷">
          <el-input v-model="searchForm.papername" placeholder="试卷名称" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-button round @click="search()">查询</el-button>
        </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
          :data="dataList"
          border
          v-loading="dataListLoading"
          @selection-change="selectionChangeHandler"
          style="width: 100%;"
        >
          <el-table-column prop="userid" header-align="center" align="center" sortable label="用户ID"></el-table-column>
          <el-table-column
            prop="papername"
            header-align="center"
            align="center"
            sortable
            label="试卷"
          ></el-table-column>
          <el-table-column
            prop="myscore"
            header-align="center"
            align="center"
            sortable
            label="考试得分"
          >
            <template slot-scope="scope">
              <el-tag v-if="scope.row.myscore==0" type="info">{{scope.row.myscore}}</el-tag>
              <el-tag v-else type="warning">{{scope.row.myscore}}</el-tag>
            </template>
          </el-table-column>
          <el-table-column
            fixed="right"
            header-align="center"
            align="center"
            width="150"
            label="操作"
          >
            <template slot-scope="scope">
              <el-button
                type="text"
                size="small"
                @click="addOrUpdateHandler(scope.row)"
              >查看详情</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="pageSize"
          :total="totalPage"
          layout="total, sizes, prev, pager, next, jumper"
          class="pagination-content"
        ></el-pagination>
      </div>
    </div>
    <add-or-update v-if="showFlag" :parent="this" ref="addOrUpdate"></add-or-update>
  </div>
</template>
<script>
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: false
    };
  },
  mounted() {
    this.init();
    this.getDataList();
  },
  components: {
    AddOrUpdate
  },
  methods: {
    init() {},
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      var params = {
        page: this.pageIndex,
        limit: this.pageSize
      };
      if (this.searchForm.papername) {
        params["papername"] = `%${this.searchForm.papername}%`;
      }
      this.$http({
        url: this.$api.examrecordgroupby,
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    addOrUpdateHandler(row) {
      this.showFlag = true;
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(row);
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
