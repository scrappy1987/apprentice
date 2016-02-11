"use strict";

(function () {

    angular.module("app").decorator("assetDal", ["$delegate", "$q", AssetDal]);

    function ProjectDal ($delegate, $q) {
        var mockAssetId = 100;
        var mockAsset =
            [{
                "aoSDMLastTicketNumber": "sSDMLastTicketNumberString",
                   "aoFOAoName": 1,
                   "contact": {
                      "id": 1,
                      "location": {
                      	"id": 1,
                      	"functionalOrg": {
                         		"id": 1,
                         		"account": "WSDS-ACCT",
                         		"smPlatform": "SmPlatform1",
                         		"cmdbPlatform": "CmdbPlatform1"
                      	},
                	     "hpamLocationId": 1,
                	     "name": "Name1",
                	     "fullName": "Location Name 1",
                	     "locationStatus": "Status1",
                	     "address1": "Address Line 1",
                	     "address2": "Address Line 2",
                	     "address3": "Address Line 3",
                	     "address4": "Address Line 4",
                	     "address5": "Address Line 5",
                	     "address6": "Address Line 6",
                	     "city": "City1",
                	     "country": "Country1",
                	     "state": "State1",
                	     "zip": "Zip1"
                	 },
                      "employeeNo": "a123456",
                      "title": "Mr",
                      "firstName": "Jim",
                      "middleName": "James",
                      "surname": "James",
                      "phone": "11111111111",
                      "mobile": "11111111111",
                      "email": "contact@email.com"
                   },
                   "assetSerialNo": "assetSerialNoString",
                   "assetLabel": "assetLabelString",
                   "assetAoCiName": "assetAoCiNameString",
                   "propertyType": {
                      "id": 2,
                      "value": "propertyTypeValue104"
                   },
                   "status": {
                      "id": 1,
                      "value": "statusValue105"
                   },
                   "assetSeverityName": "assetSeverityNameString",
                   "assetAoServiceScope": "ScopeString",
                   "model": {
                      "id": 1,
                      "brand": {
                         "id": 5,
                         "value": "brandValue100"
                      },
                      "name": "ModelName1",
                      "category": {
                         "id": 1,
                         "category": "category301",
                         "categoryType": {
                            	"id": 4,
                            	"value": "categoryTypeValue101"
                         }
                      },
                      "barCode": "0110110101010000001111001010101011"
                   },
                   "operatingSystem": {
                      "id": 3,
                      "value": "objectActionValue103"
                   },
                   "computerTcpIpHostName": "computerTcpIpHostNameString",
                   "aoATFExternalTool": "aoATFExternalToolString",
                   "aoDelete": "Del",
                   "seAssignment": "seAssignmentString",
                   "objectAction": 1,
                   "objectType": "objectTypeString",
                   "aodAssignment": "2016-01-20",
                   "dAssignment": "2016-01-20"
            }];


        $delegate.getAsset = function (criteria) {
            var deferred = $q.defer();
            if (criteria == null) {
                deferred.resolve(_.cloneDeep(mockAsset));
            } else if (criteria.hasOwnProperty('id')) {
                if (mockAsset[criteria.id] != null) {
                    deferred.resolve(_.find(mockAsset, function (asset) {
                        return asset.id = criteria.id;
                    }));
                } else {
                    deferred.reject("No assets found");
                }
            } else {
                deferred.reject("Asset cannot be saved");
            }
            return deferred.promise;
        };


        $delegate.saveAsset = function (assetToSave) {
           var deferred = $q.defer();
           if (!assetToSave.hasOwnProperty("id")) {
               assetToSave.id = mockAssetId++;
               mockAsset.push(assetToSave);
           }
               deferred.resolve(assetToSave);
               return deferred.promise;
        };

        return $delegate;
    };

});