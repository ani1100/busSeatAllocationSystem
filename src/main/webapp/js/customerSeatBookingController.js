"use strict"
var myApp = angular.module('myApp');
myApp.controller('customerSeatBookingController',customerSeatBookingController);

function  customerSeatBookingController($scope,$http){
$scope.customerseatbooking={};
$scope.available=false;

$scope.custsubmit=function()
{
	  if(($scope.customerseatbooking.startloc==null||$scope.customerseatbooking.startloc=="")||($scope.customerseatbooking.endloc==null||$scope.customerseatbooking.endloc=="")||($scope.customerseatbooking.depdate==null))
	  {
	  $scope.alert("Please Fill in all the details");
	  $scope.available=false;
	  return;
	  }
	  var d=new Date();
	  var year1 = d.getFullYear().toString();
	  var month1 = (d.getMonth()+1).toString();
      if(month1.length==1)
      {
		month1="0".concat(month1);
	  }
      var day1 = d.getDate().toString();
      if(day1.length==1)
      {
	    day1="0".concat(day1);
      }
	  var sdate=year1.concat("-").concat(month1).concat("-").concat(day1);
	  var d1=$scope.customerseatbooking.depdate;
      year1 = d1.getFullYear().toString();
	  month1 = (d1.getMonth()+1).toString();
      if(month1.length==1)
      {
		month1="0".concat(month1);
	  }
      day1 = d1.getDate().toString();
      if(day1.length==1)
      {
	    day1="0".concat(day1);
      }
      var entdate=year1.concat("-").concat(month1).concat("-").concat(day1);
      if(entdate<sdate)
      {
      $scope.alert("Entered Date less than System Date");
      $scope.available=false;
      return;
      }
      var stime;
      if(entdate==sdate)
      {
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
		  stime=hour1.concat(":").concat(min1).concat(":").concat(sec1);
      }
      else
      {
      stime="00:00:00";
      }
      $scope.customerseatbooking.deptime=entdate.concat(" ").concat(stime);
      $http({
	    method : "POST",
	      url : "customerseatbooking",
	      data: $scope.customerseatbooking
	  }).then(function mySuccess(response) { 
	  $scope.available=true;
	  $scope.resplis=response.data;
	  for(var i=0;i<$scope.resplis.length;i+=1)
	  {
	  $scope.resplis[i].backseatdtls=[];
	  $scope.resplis[i].rowseatdtls=[];
	  $scope.resplis[i].resp={};
	  $scope.resplis[i].resp.custdtls={};
	  $scope.resplis[i].resp.seatnos=[];
	  $scope.resplis[i].selseats="";
	  }
	  }, function myError(response) {
	  $scope.alert("Something went wrong.Please try Again Later");
	  });
}

$scope.custreset=function()
{
$scope.customerseatbooking={};
$scope.available=false;
}

$scope.custvalidation=function(obj,val)
{
	if(obj=="startloc")
	{
	    if(val!=null && val!="")
		{
			var str="";
			for (let i = 0; i < val.length; i++)
			{
				if((val.charCodeAt(i)>=65 && val.charCodeAt(i)<=90)||(val.charCodeAt(i)>=97 && val.charCodeAt(i)<=122))
				{
					if(i==0)
					{
					  str=str.concat(val.charAt(i).toUpperCase());
					}
					else
				    {
					  str=str.concat(val.charAt(i).toLowerCase());
					}
			    }
			     else
				 {
				        $scope.alert("Invalid Location");
				        $scope.customerseatbooking.startloc=null;
				        $scope.available=false;
				        return;
				 }
			}
			$scope.customerseatbooking.startloc=str;
		}
	}
	else if(obj=="endloc")
	{
	    if(val!=null && val!="")
		{
			var str="";
			for (let i = 0; i < val.length; i++)
			{
				if((val.charCodeAt(i)>=65 && val.charCodeAt(i)<=90)||(val.charCodeAt(i)>=97 && val.charCodeAt(i)<=122))
				{
					if(i==0)
					{
					  str=str.concat(val.charAt(i).toUpperCase());
					}
					else
				    {
					  str=str.concat(val.charAt(i).toLowerCase());
					}
			    }
			    else
				{
				        $scope.alert("Invalid Location Name");
				        $scope.customerseatbooking.endloc=null;
				        $scope.available=false;
				        return;
				}
			}
			$scope.customerseatbooking.endloc=str;
		}
	}
	else if(obj=="depdate")
	{
	  var d = new Date();
	  var year1 = d.getFullYear().toString();
	  var month1 = (d.getMonth()+1).toString();
      if(month1.length==1)
      {
		month1="0".concat(month1);
	  }
      var day1 = d.getDate().toString();
      if(day1.length==1)
      {
	    day1="0".concat(day1);
      }
      var sysdate=year1.concat("-").concat(month1).concat("-").concat(day1);	
      var d1=$scope.customerseatbooking.depdate;
      year1 = d1.getFullYear().toString();
	  month1 = (d1.getMonth()+1).toString();
      if(month1.length==1)
      {
		month1="0".concat(month1);
	  }
      day1 = d1.getDate().toString();
      if(day1.length==1)
      {
	    day1="0".concat(day1);
      }
      var entereddate=year1.concat("-").concat(month1).concat("-").concat(day1);
      if(entereddate<sysdate)
      {
      $scope.alert("Invalid Departure Date");
      $scope.available=false;
      $scope.customerseatbooking.depdate=null;
      }
	}	
}	

$scope.expandbus=function(obj,type)
{
	if(type=="expand" && obj.expansion==true)
	{
		obj.expansion=false;
	}
	else
	{
		$http({
			    method : "POST",
			      url : "fetchbusseatdetails",
			      data: obj
			  }).then(function mySuccess(response) { 
			  console.log(response.data);
			  if(response.data.status=="Failed")
			  {
			  $scope.alert(response.data.reason);
			  obj.expansion=false;
			  }
			  else
			  {
			  $scope.seatdtls=response.data;
			  obj.backseatdtls=[];
			  obj.rowseatdtls=[];
	  		  obj.resp.custdtls={};
			  obj.resp.busseatresp=response.data;
			  var ct=0;
			  for(var i=ct;i<response.data.custbook.busdetails.lastseat;i+=1)
			  {
			  ct+=1;
			  var temp=$scope.seatdtls.listseat[i];
			  (temp.status=="N")?temp.color="white":temp.color="#D8D8D8";
			  obj.backseatdtls.push(temp);
			  }
			  var ct1=0;
			  var empty=1;
			  if(ct>=1)
			  {
			  ct1=-1;
			  empty=response.data.custbook.busdetails.lastseat-response.data.custbook.busdetails.seatleftside-response.data.custbook.busdetails.seatrightside;
			  }
			  for(var j=response.data.custbook.busdetails.rows+ct1;j>0;j-=1)
			  {
				  var rowlis=[];
				  for(var k=0;k<response.data.custbook.busdetails.seatleftside;k+=1)
				  {
				   var temp=$scope.seatdtls.listseat[k+ct];
			  	   (temp.status=="N")?temp.color="white":temp.color="#D8D8D8";
			  	   rowlis.push(temp);
				  }
				  ct=ct+response.data.custbook.busdetails.seatleftside;
				  for(var k=0;k<empty;k+=1)
				  {
				   var obj1={"seatno":"-1","status":"U","color":"#6CB4EE"};
			  	   rowlis.push(obj1);
				  }
				  for(var k=0;k<response.data.custbook.busdetails.seatrightside;k+=1)
				  {
				   var temp=$scope.seatdtls.listseat[k+ct];
			  	   (temp.status=="N")?temp.color="white":temp.color="#D8D8D8";
				   rowlis.push(temp);
				  }
				  ct=ct+response.data.custbook.busdetails.seatrightside;
				  obj.rowseatdtls.push(rowlis);
			  }
			  obj.resp.seatnos=[];
			  obj.selseats="";
			  obj.expansion=true;
			  }
			  }, function myError(response) {
			  $scope.alert("Something went wrong.Please try Again Later");
			  obj.expansion=false;
		});
	}
}


$scope.allocationsubmit=function(obj)
{
    if((obj.resp.custdtls.cstmrname==null || obj.resp.custdtls.cstmrname=="")||(obj.resp.custdtls.emailid==null)||(obj.resp.custdtls.mobileno==null)||(obj.resp.seatnos.length<1))
    {
    $scope.alert("Please fill in all the details");
    return;
    }
	$http({
	    method : "POST",
	      url : "allocateseats",
	      data: obj.resp
	  }).then(function mySuccess(response) {
	  $scope.alert(response.data.message);
	  $scope.expandbus(obj,"refresh");
	  }, function myError(response) {
	  $scope.alert("Something went wrong.Please try Again Later");
	  });
}

$scope.selectseat=function(obj,obj2)
{
    if(obj2.status=="Y" || obj2.status=="U")
    {
    return;
    }
    var val1=obj.resp.seatnos.find(element => element === obj2.seatno);
	if(val1!=null)
	{
	var index1=obj.resp.seatnos.indexOf(obj2.seatno);
	obj.resp.seatnos.splice(index1, 1);
	obj2.color="white";
	}
	else
	{
	obj.resp.seatnos.push(obj2.seatno);
	obj2.color="red";
	}
	obj.selseats=obj.resp.seatnos.join(", ");
}

$scope.validatecust=function(obj,val)
{
    if(obj=="name")
	{
	  if(val.resp.custdtls.cstmrname!=null && val.resp.custdtls.cstmrname!="")
	  {
		  for (let i = 0; i < val.resp.custdtls.cstmrname.length; i++)
		  {
		      if((val.resp.custdtls.cstmrname.charCodeAt(i)>=65 && val.resp.custdtls.cstmrname.charCodeAt(i)<=90)||(val.resp.custdtls.cstmrname.charCodeAt(i)>=97 && val.resp.custdtls.cstmrname.charCodeAt(i)<=122)||(val.charCodeAt(i)==32))
		      {
		      	continue;
		      }
		      else
		      {
		        $scope.alert("Invalid Customer Name");
		        val.resp.custdtls.cstmrname=null;
		      	break;
		      }
	      }
      }
	}
	else if(obj=="email")
	{
	    if(val.resp.custdtls.emailid!=null)
		{
		
		}
		else
		{
		    $scope.alert("Invalid EmailID");
			val.resp.custdtls.emailid=null;
		}
	}
	else if(obj=="number")
	{
	    if(val.resp.custdtls.mobileno!=null)
		{
		      var str1= String(val.resp.custdtls.mobileno);
		      if(str1.length==10)
		      {
			      for (let i = 0; i < str1.length; i++)
				  {
				      if((str1.charCodeAt(i)>=48 && str1.charCodeAt(i)<=57))
				      {
				      	continue;
				      }
				      else
				      {
				        $scope.alert("Invalid Mobile No");
				        val.resp.custdtls.mobileno=null;
				      	break;
				      }
			      }
		      }
		      else
		      {
		         $scope.alert("Invalid Mobile No");
		     	 val.resp.custdtls.mobileno=null;
		      }
		}
		else
		{
		 $scope.alert("Invalid Mobile No");
		 val.resp.custdtls.mobileno=null;
		}
	}
}

}