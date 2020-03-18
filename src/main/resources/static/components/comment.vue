<template>
    <div>
        <div  v-for="(comment, index) in comments" :key="index">
            <div>
                <span>{{comment.nickname}}</span>
            </div>
            <div v-if="comment.commentChildren" >
                <comment :comments="item.children"></comment>
            </div>
        </div>
    </div>
</template>
<script>
    new Vue({
        name: "Comment",
        props: {
            comments: [],
        }
    });
</script>