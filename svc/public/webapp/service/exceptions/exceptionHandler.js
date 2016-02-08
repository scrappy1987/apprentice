
(function() {

    angular.module("app").config(function ($provide) {

          $provide.decorator("$exceptionHandler", function ($delegate, $injector) {
            return function(exception, cause) {
                    $delegate(exception, cause);
                    if (exception.status === 500) {
                        console.log(this.exception + cause);
                    };
                }
          });
    });
});