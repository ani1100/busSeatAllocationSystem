"use strict"
var myApp = angular.module('myApp',[]);
myApp.controller('singleBusRegistrationController', singleBusRegistrationController);

function  singleBusRegistrationController($scope,$http){
$scope.singlebusreg={};
$scope.expansion1=true;
$scope.expansion2=false;
$scope.expansion3=false;
$scope.expansion4=false;
$scope.lisseats=[1,2,3];
$scope.lisbackseats=[0,1,2,3,4,5,6];
$scope.busdesign=false;
$scope.stoppagelis=[];
$scope.singlebusreg.lisstoppages=[];
$scope.basicdetails=false;
$scope.tripdetails=false;
$scope.stoppagedetails=false;

$scope.reset=function()
{
$scope.singlebusreg={};
$scope.expansion1=true;
$scope.expansion2=false;
$scope.expansion3=false;
$scope.expansion4=false;
$scope.busdesign=false;
$scope.singlebusreg.lisstoppages=[];
$scope.stoppagelis=[];
$scope.basicdetails=false;
$scope.tripdetails=false;
$scope.stoppagedetails=false;
}

$scope.expand=function(obj)
{
	if(obj=="basicdetail")
	{
		if($scope.expansion1==true)
		{
		$scope.expansion1=false;
		}
		else
		{
		$scope.expansion1=true;
		}
	}
	else if(obj=="busdetails")
	{
		if($scope.expansion2==true)
		{
		$scope.expansion2=false;
		}
		else
		{
		$scope.expansion2=true;
		}
	}
	else if(obj=="stoppagedetails")
	{
		if($scope.expansion3==true)
		{
		$scope.expansion3=false;
		}
		else
		{
		$scope.expansion3=true;
		}
	}
	else if(obj=="stoppages")
	{
		if($scope.expansion4==true)
		{
		$scope.expansion4=false;
		}
		else
		{
		$scope.expansion4=true;
		}
	}
}



$scope.seatclick=function()
{
$scope.singlebusreg.seatlastseat=null;
$scope.singlebusreg.seatleftside=null;
$scope.singlebusreg.seatrightside=null;
$scope.singlebusreg.rows=null;
$scope.busdesign=false;
}

$scope.validations=function(obj,val)
{
    if(obj=="owner")
	{
	  if(val!=null && val!="")
	  {
		  for (let i = 0; i < val.length; i++)
		  {
		      if((val.charCodeAt(i)>=65 && val.charCodeAt(i)<=90)||(val.charCodeAt(i)>=97 && val.charCodeAt(i)<=122)||(val.charCodeAt(i)==32))
		      {
		      	continue;
		      }
		      else
		      {
		      	$scope.alert("Invalid Owner Name");
		        $scope.singlebusreg.ownername=null;
		      	break;
		      }
	      }
      }
	}
	else if(obj=="plate")
	{
		  if(val!=null && val!="")
		  {
			  if((val.charCodeAt(0)>=48 && val.charCodeAt(0)<=57))
			  {
			  	$scope.alert("Invalid Bus Number Plate");
			    $scope.singlebusreg.busnumberplate=null;
			    return;
			  }
			  for (let i = 0; i < val.length; i++)
		      {
			      if((val.charCodeAt(i)>=65 && val.charCodeAt(i)<=90)||(val.charCodeAt(i)>=48 && val.charCodeAt(i)<=57))
			      {
			      	continue;
			      }
			      else
			      {
			        $scope.alert("Invalid Bus Number Plate");
			        $scope.singlebusreg.busnumberplate=null;
			      	return;
			      }    
	          }
	       
	          $http({
			    method : "POST",
			      url : "checkusername",
			      data: val
			  }).then(function mySuccess(response) { 
			  if(response.data.status=="Failed")
			  {
			   $scope.alert(response.data.message);
			   $scope.singlebusreg.busnumberplate=null;
			  }
			  }, function myError(response) {
			  $scope.alert("Something went wrong. Please Try Again Later.");
			  $scope.singlebusreg.busnumberplate=null;
			  });
		  }
	}
	else if(obj=="mobile")
	{
		if($scope.singlebusreg.mobileno!=null)
		{
		      val= String(val);
		      if(val.length==10)
		      {
			      for (let i = 0; i < val.length; i++)
				  {
				      if((val.charCodeAt(i)>=48 && val.charCodeAt(i)<=57))
				      {
				      	continue;
				      }
				      else
				      {
				        $scope.alert("Invalid Mobile No");
				        $scope.singlebusreg.mobileno=null;
				      	break;
				      }
			      }
		      }
		      else
		      {
		         $scope.alert("Invalid Mobile No");
		     	 $scope.singlebusreg.mobileno=null;
		      }
		}
		else
		{
		 $scope.singlebusreg.mobileno=null;
		}
	}
	else if(obj=="email")
	{ 
		if(val!=null)
		{
		
		}
		else
		{
		    $scope.alert("Invalid EmailID");
			$scope.singlebusreg.emailid=null;
		}
	}
	else if(obj=="seats")
	{
		if(val==null)
		{
			$scope.alert("Seats Ranges from 10 to 60");
			$scope.singlebusreg.seats=null;
		}
		else
		{
			if(val<10 || val>60)
			{
			   $scope.alert("Seats Ranges from 10 to 60");
			   $scope.singlebusreg.seats=null;
			}
		}
	}
	else if(obj=="lseat"||obj=="rseat"||obj=="lastseat")
	{
		if($scope.singlebusreg.seatleftside!=null && $scope.singlebusreg.seatrightside!=null && $scope.singlebusreg.seatlastseat!=null)
		{
			 if($scope.singlebusreg.seatleftside==3 && $scope.singlebusreg.seatrightside==3)
			 {
			 	$scope.alert("This Bus Deisgn is not Feasible");
			 	$scope.busdesign=false;
			 	$scope.singlebusreg.rows=null;
			 }
			 else
			 {	 
				 var row1=$scope.singlebusreg.seatleftside+$scope.singlebusreg.seatrightside;
				 if($scope.singlebusreg.seatlastseat==0||$scope.singlebusreg.seatlastseat==row1+1||$scope.singlebusreg.seatlastseat==row1+2)
				 {
				 	var temp=$scope.singlebusreg.seats-$scope.singlebusreg.seatlastseat;
				 	if(temp%row1==0)
					{
					 	$scope.singlebusreg.rows=temp/row1;
					 	$scope.busdesign=true;
					 	if($scope.singlebusreg.seatlastseat>0)
					 	{
					 	$scope.singlebusreg.rows+=1;
					 	}
					}
					else
					{
					 	$scope.alert("This Bus Deisgn is not Feasible");
					 	$scope.busdesign=false;
					 	$scope.singlebusreg.rows=null;
					}
				 }
				 else
				 {
				 	$scope.alert("This Bus Deisgn is not Feasible");
				 	$scope.busdesign=false;
				 	$scope.singlebusreg.rows=null;
				 }		 
			 }
		}
		else
		{
			$scope.singlebusreg.rows=null;
			$scope.busdesign=false;
		}
	}
	else if(obj=="endpoint1")
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
		        $scope.alert("Invalid Enpoint");
		        $scope.singlebusreg.endpoint1=null;
		        if($scope.singlebusreg.nostoppages!=null)
			    {
			      $scope.stoppagelis[0].locname=null;
			    }
		      	return;
		      }
	      }
	      $scope.singlebusreg.endpoint1=str;
	      if($scope.singlebusreg.nostoppages!=null)
	      {
	      $scope.stoppagelis[0].locname=$scope.singlebusreg.endpoint1;
	      }
      }
      else
      {
	      if($scope.singlebusreg.nostoppages!=null)
		  {
			$scope.stoppagelis[0].locname=null;
		  }
      }
	}
	else if(obj=="endpoint2")
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
			        $scope.alert("Invalid Enpoint");
			        $scope.singlebusreg.endpoint2=null;
			        if($scope.singlebusreg.nostoppages!=null)
				    {
				      $scope.stoppagelis[$scope.singlebusreg.nostoppages-1].locname=null;
				    }
			      	return;
			      }
		      }
		      $scope.singlebusreg.endpoint2=str;
		      if($scope.singlebusreg.nostoppages!=null)
		      {
		      $scope.stoppagelis[$scope.singlebusreg.nostoppages-1].locname=$scope.singlebusreg.endpoint2;
		      }
	      }
	      else
	      {
	          if($scope.singlebusreg.nostoppages!=null)
		      {
		      $scope.stoppagelis[$scope.singlebusreg.nostoppages-1].locname=null;
		      }
	      }
	}
	else if(obj=="stoppagesno")
	{
		$scope.stoppagelis=[];
	    if(val==null)
		{
			$scope.alert("Stoppages Ranges from 2 to 10");
			$scope.singlebusreg.nostoppages=null;
			$scope.stoppagelis=[];
		}
		else
		{
			if(val<2 || val>10)
			{
			   $scope.alert("Stoppages Ranges from 2 to 10");
			   $scope.singlebusreg.nostoppages=null;
			   $scope.stoppagelis=[];
			}
			else
			{
				for (let i = 0; i < $scope.singlebusreg.nostoppages; i++)
	  			{
	      			  if(i==0)
				      {
				      var obj={"locname":$scope.singlebusreg.endpoint1,"disable":true};
				      $scope.stoppagelis.push(obj);
				      }
				      else if(i==$scope.singlebusreg.nostoppages-1)
				      {
				      var obj={"locname":$scope.singlebusreg.endpoint2,"disable":true};
				      $scope.stoppagelis.push(obj); 
				      }
				      else
				      {
				      var obj={"locname":"","disable":false};
				      $scope.stoppagelis.push(obj);
				      }
				}
            }
	    }
	}
	else if(obj=="esthr")
	{
		    if(val==null)
			{
				$scope.alert("Invalid Estimated Time");
				$scope.singlebusreg.esthr=null;
			}
			else
			{
				if(val<0 || val>24)
				{
				   $scope.alert("Invalid Estimated Time");
				   $scope.singlebusreg.esthr=null;
				}
			}
	}
	else if(obj=="estmin")
	{
			if(val==null)
			{
				$scope.alert("Invalid Estimated Time");
				$scope.singlebusreg.estmin=null;
			}
			else
			{
				if(val<0 || val>60)
				{
				   $scope.alert("Invalid Estimated Time");
				   $scope.singlebusreg.estmin=null;
				}
			}
	}
	else if(obj=="stoppages")
	{
		  if(val.locname!=null && val.locname!="")
		  {
		      var str="";
			  for (let i = 0; i < val.locname.length; i++)
			  {
			      if((val.locname.charCodeAt(i)>=65 && val.locname.charCodeAt(i)<=90)||(val.locname.charCodeAt(i)>=97 && val.locname.charCodeAt(i)<=122))
			      {
			      if(i==0)
			      {
			      str=str.concat(val.locname.charAt(i).toUpperCase());
			      }
			      else
			      {
			      str=str.concat(val.locname.charAt(i).toLowerCase());
			      }
			      }
			      else
			      {
			        $scope.alert("Invalid Stoppage Name");
			        val.locname=null;
			      	return;
			      }
		      }
		      val.locname=str;
	      }
	}
	if(($scope.singlebusreg.busname!=null && $scope.singlebusreg.busname!="")&&($scope.singlebusreg.ownername!=null && $scope.singlebusreg.ownername!="")&&($scope.singlebusreg.busnumberplate!=null && $scope.singlebusreg.busnumberplate!="")&&($scope.singlebusreg.mobileno!=null)&&($scope.singlebusreg.emailid!=null))
	{
		$scope.basicdetails=true;
	}
	else
	{
		$scope.basicdetails=false;
	}
	if(($scope.singlebusreg.nostoppages!=null)&&($scope.singlebusreg.estmin!=null)&&($scope.singlebusreg.esthr!=null)&&($scope.singlebusreg.endpoint2!=null && $scope.singlebusreg.endpoint2!="")&&($scope.singlebusreg.endpoint1!=null && $scope.singlebusreg.endpoint1!=""))
	{
		$scope.tripdetails=true;
	}
	else
	{
		$scope.tripdetails=false;
	}
	if($scope.singlebusreg.nostoppages!=null)
	{
		for(var i=0;i<$scope.singlebusreg.nostoppages;i+=1)
		{
			if($scope.stoppagelis[i].locname!=null && $scope.stoppagelis[i].locname!="")
			{
				$scope.singlebusreg.lisstoppages.push($scope.stoppagelis[i].locname);
			}
			else
			{
			$scope.singlebusreg.lisstoppages=[];
			break;
			}
		}
		if($scope.singlebusreg.lisstoppages.length==0)
		{
			$scope.stoppagedetails=false;
		}
		else
		{
			$scope.stoppagedetails=true;
		}
	}
	else
	{
	$scope.stoppagedetails=false;
	}
	
}

$scope.busregsubmit=function()
{
	if($scope.basicdetails==false||$scope.busdesign==false||$scope.tripdetails==false||$scope.stoppagedetails==false)
	{
		$scope.alert("Please fill all details");
		return;
	}
	$http({
	method : "POST",
	url : "singleregisterbus",
	data: $scope.singlebusreg
	}).then(function mySuccess(response) { 
	if(response.data.status=="Failed")
	{
	$scope.alert(response.data.message);
	}
	else
	{
	$scope.alert(response.data.message);
	$scope.reset();
	}
	}, function myError(response) {
	$scope.alert("Something went wrong.Please try Again Later");
	});
}

}