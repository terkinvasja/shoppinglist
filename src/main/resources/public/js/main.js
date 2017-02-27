/**
 * Created by Vasili on 026 26.02.17.
 */
var app = angular.module("shoppinglistApplication", []);

app.controller("AppCtrl", AppCtrl);

function AppCtrl($http) {
    //this.users = [];
    var vm = this;
    vm.users = [];
    $http.get('http://localhost:8080/rest/admin/users')
        .then(function (result) {
            vm.users = result.data;
            console.log(result);
        }, function (result) {
            //some error
            console.log(result);
        });
}
