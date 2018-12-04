
var voteApi = Vue.resource('/vote{/id}');
Vue.component('vote-row',{
     props:['vote'],
    template:'<div><i>({{vote.id}})</i>{{vote.name}}</div>'
});
Vue.component('votes-list', {
    props:['votes'],
    template:
    '<div>'+ '<vote-row v-for="vote in votes" :key="vote.id" :vote="votes"/>'+'</div>',
    created: function () {
        voteApi.get().then(result =>
            result.json().then(data =>
                data.forEach(vote =>this.votes.push(vote))))
    }
});

var app = new Vue({
    el: '#app',
    template: '<votes-list :votes="votes" />',
    data: {
        votes: []
    }
});