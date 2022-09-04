"use strict"
var myApp = angular.module('myApp');
myApp.controller('HomeController',HomeController);

function HomeController($scope,$http){
$scope.bussearch=false;
$scope.fetchbusdetails=function()
{
	  if($scope.searchbus==null||$scope.searchbus=="")
	  {
	  $scope.bussearch=false;
	  return;
	  }	
      $http({
	    method : "POST",
	      url : "fetchbusdetails",
	      data: $scope.searchbus
	  }).then(function mySuccess(response) {
	  if(response.data.status=="Failed")
	  {
	  	$scope.bussearch=false;
	  }
	  else
	  {
		  $scope.busdtlsinfo=response.data; 
		  $scope.places=[response.data.busdtls.endpoint1,response.data.busdtls.endpoint2];
		  $scope.backseatstr=[];
		  $scope.rowseatstr=[];
		  var ct=0;
		  for(var i=ct;i<$scope.busdtlsinfo.busdtls.lastseat;i+=1)
		  {
			  ct+=1;
			  var temp={"status":"N","color":"ivory"};
			  $scope.backseatstr.push(temp);
		  }
		  var ct1=0;
		  var empty=1;
		  if(ct>=1)
		  {
			  ct1=-1;
			  empty=$scope.busdtlsinfo.busdtls.lastseat-$scope.busdtlsinfo.busdtls.seatleftside-$scope.busdtlsinfo.busdtls.seatrightside;
		  }
		  for(var j=$scope.busdtlsinfo.busdtls.rows+ct1;j>0;j-=1)
		  {
			      var rowlis=[];
				  for(var k=0;k<$scope.busdtlsinfo.busdtls.seatleftside;k+=1)
				  {
				   var temp={"status":"N","color":"ivory"};
			  	   rowlis.push(temp);
				  }
				  ct=ct+$scope.busdtlsinfo.busdtls.seatleftside;
				  for(var k=0;k<empty;k+=1)
				  {
				   var temp={"status":"N","color":"#0071c5"};
			  	   rowlis.push(temp);
				  }
				  for(var k=0;k<$scope.busdtlsinfo.busdtls.seatrightside;k+=1)
				  {
				   var temp={"status":"N","color":"ivory"};
			  	   rowlis.push(temp);
				  }
				  ct=ct+$scope.busdtlsinfo.busdtls.seatrightside;
				  $scope.rowseatstr.push(rowlis);
		  }
		  $scope.bussearch=true;	
		  document.getElementById("busch").click();
	  }
	  }, function myError(response) {
	  $scope.bussearch=false;
	  });
}

$scope.alert=function(val)
{
$scope.alertmessage=val;
document.getElementById("id1").click();
}

}