
(function() {

    angular.module("app").config(function($provide) {
        $provide.decorator("$exceptionHandler", ['$delegate', 'toastr', function($delegate, toastr) {
            return function(exception, cause) {
                if (exception.status === 500) {
                    toastr.error('System Unavailable Please Contact Your Administrator', 'Error');
                };
                $delegate(exception, cause);
                return $delegate;
            };
        }]);
    });
});