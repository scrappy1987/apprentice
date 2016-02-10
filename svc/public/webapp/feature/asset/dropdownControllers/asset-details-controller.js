(function () {

    angular.module("app").controller("assetDetailsController", ["propertyTypeRepository", "statusRepository", AssetDetailsCtrl]);

    function AssetDetailsCtrl (propertyTypeRepository, locationRepository) {
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
        StatusRepository.getStatus().then(function (results) {
            vm.Status = results;
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });




           }

        }());