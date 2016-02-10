(function () {

    angular.module("app").controller("assetDetailsController", ["propertyTypeRepository", "statusRepository", AssetDetailsCtrl]);

    function AssetDetailsCtrl (propertyTypeRepository, statusRepository) {
        var vm = this;

        /*
         * Property Type
         */
        propertyTypeRepository.getPropertyType().then(function (results) {
            vm.propertyTypes = results;
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });

         /*
         * Status
         */
        statusRepository.getStatus().then(function (results) {
            vm.statuses = results;
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });




           }

        }());