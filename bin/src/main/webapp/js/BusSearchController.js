"use strict"
var myApp = angular.module('myApp');
myApp.controller('BusSearchController',BusSearchController);

function BusSearchController($scope,$http){

$scope.schtrips=function()
{
      $http({
	    method : "POST",
	      url : "fetchuncompletedtrips",
	      data: $scope.busdtlsinfo.busdtls.busnumberplate
	  }).then(function mySuccess(response) {
	  $scope.busdtlsinfo.scheduledtrip=response.data; 
	  console.log(response.data);
	  $scope.viewschtrips = [];
	  for(var i=0;i<$scope.busdtlsinfo.scheduledtrip.length;i+=1)
	  {
	      var obj={};
		  if($scope.busdtlsinfo.scheduledtrip[i].flag==0)
		  {
			  obj.startpoint=$scope.busdtlsinfo.busdtls.endpoint1;
			  obj.endpoint=$scope.busdtlsinfo.busdtls.endpoint2;
		  }
		  else
		  {
			  obj.startpoint=$scope.busdtlsinfo.busdtls.endpoint2;
			  obj.endpoint=$scope.busdtlsinfo.busdtls.endpoint1;
		  }
		  var objd= $scope.busdtlsinfo.scheduledtrip[i].arrivaltime.split(" ")[0].split("-");
		  obj.arrdate= objd[2].concat("/").concat(objd[1]).concat("/").concat(objd[0]);
		  obj.arrtime= $scope.busdtlsinfo.scheduledtrip[i].arrivaltime.split(" ")[1];
		  objd= $scope.busdtlsinfo.scheduledtrip[i].deptime.split(" ")[0].split("-");
		  obj.depdate= objd[2].concat("/").concat(objd[1]).concat("/").concat(objd[0]);
		  obj.deptime= $scope.busdtlsinfo.scheduledtrip[i].deptime.split(" ")[1];
		  obj.buschid= $scope.busdtlsinfo.scheduledtrip[i].id;
		  $scope.viewschtrips.push(obj);
		  console.log(obj);
	  }
	  }, function myError(response) {
	  console.log(response);
	  });
}
$scope.completedtrips=function()
{
      $http({
	    method : "POST",
	      url : "fetchcompletedtrips",
	      data: $scope.busdtlsinfo.busdtls.busnumberplate
	  }).then(function mySuccess(response) {
	  $scope.busdtlsinfo.completedtrip=response.data; 
	  $scope.comptrips = [];
	  for(var i=0;i<$scope.busdtlsinfo.completedtrip.length;i+=1)
	  {
	      var obj={};
		  if($scope.busdtlsinfo.completedtrip[i].flag==0)
		  {
			  obj.startpoint=$scope.busdtlsinfo.busdtls.endpoint1;
			  obj.endpoint=$scope.busdtlsinfo.busdtls.endpoint2;
		  }
		  else
		  {
			  obj.startpoint=$scope.busdtlsinfo.busdtls.endpoint2;
			  obj.endpoint=$scope.busdtlsinfo.busdtls.endpoint1;
		  }
		  var objd= $scope.busdtlsinfo.completedtrip[i].arrivaltime.split(" ")[0].split("-");
		  obj.arrdate= objd[2].concat("/").concat(objd[1]).concat("/").concat(objd[0]);
		  obj.arrtime= $scope.busdtlsinfo.completedtrip[i].arrivaltime.split(" ")[1];
		  objd= $scope.busdtlsinfo.completedtrip[i].deptime.split(" ")[0].split("-");
		  obj.depdate= objd[2].concat("/").concat(objd[1]).concat("/").concat(objd[0]);
		  obj.deptime= $scope.busdtlsinfo.completedtrip[i].deptime.split(" ")[1];
		  $scope.comptrips.push(obj);
		  console.log(obj);
	  }
	  }, function myError(response) {
	  console.log(response);
	  });
}
$scope.change1=function(obj)
{
	if(obj=="start")
	{
		if($scope.busdtlsinfo.startpoint==$scope.places[0])
		{
		$scope.busdtlsinfo.flag=0;
		$scope.busdtlsinfo.endpoint=$scope.places[1];
		}
		else
		{
		$scope.busdtlsinfo.endpoint=$scope.places[0];
		$scope.busdtlsinfo.flag=1;
		}
	}
	else
	{
	    if($scope.busdtlsinfo.endpoint==$scope.places[0])
		{
		$scope.busdtlsinfo.flag=1;
		$scope.busdtlsinfo.startpoint=$scope.places[1];
		}
		else
		{
		$scope.busdtlsinfo.flag=0;
		$scope.busdtlsinfo.startpoint=$scope.places[0];
		}
	}
}

$scope.resetbus=function()
{
$scope.busdtlsinfo.startpoint=null;
$scope.busdtlsinfo.endpoint=null;
$scope.busdtlsinfo.depdate=null;
$scope.busdtlsinfo.deptime=null;
$scope.busdtlsinfo.arrdate=null;
$scope.busdtlsinfo.arrtime=null;
}
$scope.schedulebus=function()
{
if(($scope.busdtlsinfo.arrtime==null)||($scope.busdtlsinfo.arrdate==null)||($scope.busdtlsinfo.deptime==null)||($scope.busdtlsinfo.depdate==null)||($scope.busdtlsinfo.endpoint==null)||($scope.busdtlsinfo.startpoint==null))
{
	$scope.alert("Please Fill in all the details");
	return;
}
else
{
	var d = new Date($scope.busdtlsinfo.arrdate);
	var month = '' + (d.getMonth() + 1);
	var day = '' + d.getDate();
	var year = d.getFullYear();
	if (month.length < 2) {
	     month = '0' + month;}
	if (day.length < 2) {
	        day = '0' + day;}
	var arrd=[year, month, day].join('-'); 
	d = new Date($scope.busdtlsinfo.depdate);
	month = '' + (d.getMonth() + 1);
	day = '' + d.getDate();
	year = d.getFullYear();
	if (month.length < 2) {
	     month = '0' + month;}
	if (day.length < 2) {
	        day = '0' + day;}   
	}
	var depd=[year, month, day].join('-'); 
	d = new Date();
    year = d.getFullYear().toString();
    month = (d.getMonth()+1).toString();
	if(month.length==1)
	{
		month="0".concat(month);
	}
    day = d.getDate().toString();
	if(day.length==1)
	{
		day="0".concat(day);
	}
	var hour1= d.getHours().toString();	
	if(hour1.length==1)
	{
		hour1="0".concat(hour1);
	}
	var min1= d.getMinutes().toString();
	if(min1.length==1)
	{
		min1="0".concat(min1);
	}	
	var sec1= d.getSeconds().toString();
	if(sec1.length==1)
	{
		sec1="0".concat(sec1);
	}
	var sysdate=year.concat("-").concat(month).concat("-").concat(day);
	var systime=hour1.concat(":").concat(min1).concat(":").concat(sec1);
	var sysdatetime=sysdate.concat(" ").concat(systime);//System Date
	var arrt=document.getElementById("arrtime").value.concat(":").concat("00");
	var dept=document.getElementById("deptime").value.concat(":").concat("00");
	$scope.busdtlsinfo.arrddate=arrd.concat(" ").concat(arrt);//Arrival Date
	$scope.busdtlsinfo.depddate=depd.concat(" ").concat(dept);//Departure Date
	var arr = $scope.busdtlsinfo.depddate.split(/-|\s|:/);// split string and create array.
    var estminutes=$scope.busdtlsinfo.busdtls.esthr*60 + $scope.busdtlsinfo.busdtls.estmin;
    var minminutes=estminutes-Math.floor(estminutes/4);
    var maxminutes=estminutes+Math.floor(estminutes/4);
    var dt = new Date(arr[0], arr[1] -1, arr[2], arr[3], arr[4], arr[5]);
    dt.setMinutes(dt.getMinutes() + minminutes);
    year = dt.getFullYear().toString();
    month = (dt.getMonth()+1).toString();
	if(month.length==1)
	{
		month="0".concat(month);
	}
    day = dt.getDate().toString();
	if(day.length==1)
	{
		day="0".concat(day);
	}
	hour1= dt.getHours().toString();	
	if(hour1.length==1)
	{
		hour1="0".concat(hour1);
	}
	min1= dt.getMinutes().toString();
	if(min1.length==1)
	{
		min1="0".concat(min1);
	}	
	sec1= dt.getSeconds().toString();
	if(sec1.length==1)
	{
		sec1="0".concat(sec1);
	}
	var estdtmin=year.concat("-").concat(month).concat("-").concat(day);
	var esttimemin=hour1.concat(":").concat(min1).concat(":").concat(sec1);
	var estdatetimemin=estdtmin.concat(" ").concat(esttimemin); //Minimum Scheduling Time
	dt = new Date(arr[0], arr[1] -1, arr[2], arr[3], arr[4], arr[5]);
    dt.setMinutes(dt.getMinutes() + maxminutes);
    year = dt.getFullYear().toString();
    month = (dt.getMonth()+1).toString();
	if(month.length==1)
	{
		month="0".concat(month);
	}
    day = dt.getDate().toString();
	if(day.length==1)
	{
		day="0".concat(day);
	}
	hour1= dt.getHours().toString();	
	if(hour1.length==1)
	{
		hour1="0".concat(hour1);
	}
	min1= dt.getMinutes().toString();
	if(min1.length==1)
	{
		min1="0".concat(min1);
	}	
	sec1= dt.getSeconds().toString();
	if(sec1.length==1)
	{
		sec1="0".concat(sec1);
	}
	var estdtmax=year.concat("-").concat(month).concat("-").concat(day);
	var esttimemax=hour1.concat(":").concat(min1).concat(":").concat(sec1);
	var estdatetimemax=estdtmax.concat(" ").concat(esttimemax); //Maximum Scheduling Time
	if(sysdatetime.localeCompare($scope.busdtlsinfo.depddate)==1)
	{
	$scope.alert("Start Date should be greater than System Date");
	}
	else if($scope.busdtlsinfo.depddate.localeCompare($scope.busdtlsinfo.arrddate)==1)
	{
	$scope.alert("Start Date cannot be greater than End Date");
	}
	else if(estdatetimemin.localeCompare($scope.busdtlsinfo.arrddate)==1)
	{
	$scope.alert("Arrival Time is too less. Cannot schedule bus");
	}
	else if($scope.busdtlsinfo.arrddate.localeCompare(estdatetimemax)==1)
	{
	$scope.alert("Arrival Time is too high. Cannot schedule bus");
	}
	else
	{
	 var obj={"busdetails":$scope.busdtlsinfo.busdtls,"deptime":$scope.busdtlsinfo.depddate,"arrtime":$scope.busdtlsinfo.arrddate,"flag":$scope.busdtlsinfo.flag,"locationname":$scope.busdtlsinfo.locationname};
	 console.log(obj);
	 $http({
	    method : "POST",
	      url : "schedulebus",
	      data: obj
	  }).then(function mySuccess(response) {
	  if(response.data.status=="Failed")
	  {
	  	$scope.alert(response.data.message);
	  }
	  else
	  {
	  	$scope.alert(response.data.message);
	  	$scope.resetbus();
	  } 
	  }, function myError(response) {
	  $scope.alert("Something went wrong.Please Try Again Later")
	  console.log(response);
	  });
	}
}

}