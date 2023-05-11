let productAPI = "http://localhost:8080/api";
let accountAPI = "http://localhost:8080/account";



function productCtrl($scope, $http, $routeParams, $location, $rootScope) {

    // login
    $scope.$rootScope = $rootScope;

    $scope.listAccount = [];

    $scope.listError = [];



    $http
        .get(accountAPI)
        .then(function (response) {
            $scope.listAccount = response.data
        })

    $scope.loginEmpty = {
        userName: "",
        password: "",
    }

    $scope.login = function () {
        $http.post(accountAPI, $scope.loginEmpty)

        let userName = $scope.listAccount.find(function (user) {
            return user.userName === $scope.loginEmpty.userName && user.password === $scope.loginEmpty.password
        });


        if (userName) {
            alert("Login successfully !")

            $rootScope.user = userName.name;

            $rootScope.role = userName.role;

            $rootScope.login = true;


            if (userName.role == 1) {
                $rootScope.admin = true;
                $rootScope.guest = true;
                $rootScope.delete = true;
            } else if (userName.role == 0) {
                $rootScope.admin = true;
                $rootScope.guest = true;
                $rootScope.delete = false;

            } else {

                $rootScope.admin = false;
                $rootScope.guest = false;

            }


            $location.path("/home")

        } else {
            alert("Login fail !")
            $scope.username = "";
            $scope.password = ""
        }


    };
    // login

    $scope.logout = function () {
        $rootScope.user = "Login"
        $location.path("/login");
        $rootScope.login = false;
        $rootScope.admin = false;
        $rootScope.guest = false;
        $rootScope.delete = false;

        $rootScope.role = -1 ;

        // window.location.reload();

    }

    $scope.idUrl = $routeParams.id;

    $scope.changeDeleted = function () {
        $scope.listAll = [];
        $http
            .get(productAPI + "/product" + $scope.showProduct)
            .then(function (response) {
                $scope.listAll = response.data;
            })
            .catch(function (error) {
                console.log(error);
            })
    }
    $scope.changePrice = function () {
        $scope.listAll = [];
        $http
            .get(productAPI + "/product/findPrice/" + $scope.showPrice)
            .then(function (response) {
                $scope.listAll = response.data;
            })
            .catch(function (error) {
                console.log(error);
            })
    }
    $scope.listAll = [];
    $http
        .get(productAPI + "/product")
        .then(function (response) {
            $scope.listAll = response.data;
        })
        .catch(function (error) {
            console.log(error);
        })


    $scope.listUndeleted = [];
    $http
        .get(productAPI + "/product/undeleted")
        .then(function (response) {
            $scope.listUndeleted = response.data;
        })

    $scope.listDeleted = [];
    $http
        .get(productAPI + "/product/deleted")
        .then(function (response) {
            $scope.listDeleted = response.data;
        })



    $scope.productEmpty = {
        id: 0,
        name: "",
        size: "",
        color: "",
        price: "",
        quantity: "",
        description: "",
        createdUser: "",
        createdDate: "",
        lastModifiedUser: "",
        lastModifiedDate: "",
        deleted: "",
    }


    $scope.$on("$routeChangeStart", function () {
        if ($rootScope.role != 1 && $rootScope.role != 0) {
            if ($location.path() === "/add" || $location.path() === "/update") {
                $location.path("/home");
                alert("Không có quyền sử dụng chức năng này !!");
            }
        }

    });
    $scope.$on("$routeChangeStart", function () {
        if ($rootScope.role == 1 || $rootScope.role == 0) {
            if ($location.path() === "/login") {
                $location.path("/home");
                alert("Bạn đã đăng nhập rồi !!");
            }
        }

    });


    // add product
    $scope.add = function () {

        $scope.productEmpty.createdUser = $rootScope.user;

        if ($rootScope.role == 1 || $rootScope.role == 0) {
            $http
                .post(productAPI + "/add", $scope.productEmpty)
                .then(function () {
                    $scope.listAll.push($scope.productEmpty)
                    alert("Add product successfully !!!")
                    $http
                        .get(productAPI + "/product/undeleted")
                        .then(function (response) {
                            $scope.listUndeleted = response.data;
                        })
                })
                .catch(function (error) {
                    $scope.listError = error.data

                })
        } else {
            alert("Không có quyền sử dụng chức năng này !!");
        }
    }
    // detail product
    $scope.detail = function (index) {
        const id = $scope.listAll[index].id;
        $http
            .get(productAPI + "/product/detail/" + id)
            .then(function (response) {
                $scope.productEmpty = response.data
            })
            .catch(function(){
                alert("Không tìm thấy đối tượng cần tìm !!!")
            })

    }
    // update product
    $scope.update = function () {
        $scope.productEmpty.lastModifiedUser = $rootScope.user;
        const idUpdate = $routeParams.id;
        $http
            .put(productAPI + "/update/" + idUpdate, $scope.productEmpty)
            .then(function () {
                alert("Update Product Successfull!!!");

                $http
                    .get(productAPI + "/product")
                    .then(function (response) {
                        $scope.listAll = response.data;
                    })


            })
            .catch(function (error) {
                $scope.listError = error.data;
            })
    }
    // delete product
    $scope.delete = function (index) {
        if ($rootScope.role == 1) {

            const idDelete = $scope.listUndeleted[index].id;
            $http
                .get(productAPI + "/product/detail/" + idDelete)
                .then(function (response) {
                    $scope.productEmpty = response.data;
                    $http
                        .put(productAPI + "/delete/" + idDelete, $scope.productEmpty)
                        .then(function () {
                            alert("Delete Product Successfull!!!")
                            $http
                                .get(productAPI + "/product/undeleted")
                                .then(function (response) {
                                    $scope.listUndeleted = response.data;
                                })
                        })
                        .catch(function (e) {
                            alert("Không có quyền sử dụng chức năng này!");
                        });
                });
        }
    }




    $scope.sortColumn = "name";
    $scope.reverse = false;
    $scope.sortData = function (column) {
        $scope.reverse = ($scope.sortColumn == column) ? !$scope.reverse : false;
        $scope.sortColumn = column;
    }



}




