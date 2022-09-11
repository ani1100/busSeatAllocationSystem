<div class="container" style="background-color:#e7feff;" data-ng-controller="singleBusRegistrationController">
  <h2 class="d-flex justify-content-center">Bus Registration</h2>
  <br>
  <form>
  
  <h1 data-ng-click="expand('basicdetail')" class="verticaltabs"><span class="glyphicon glyphicon-plus" ng-show="!expansion1"></span><span class="glyphicon glyphicon-minus" ng-show="expansion1"></span> Basic Details</h1><br>
  <div class="container" ng-show="expansion1">
	<div class="form-group">
      <label for="busname">Bus Name</label>
      <input type="text" class="form-control" id="busname" placeholder="Enter bus name" data-ng-model="singlebusreg.busname" ng-blur="validations('busname',singlebusreg.busname)" style="width:97%;">
    </div>
    <div class="form-group">
      <label for="ownername" >Owner Name</label>
      <input type="text" id="ownername" placeholder="Enter owner name" data-ng-model="singlebusreg.ownername" class="form-control" ng-blur="validations('owner',singlebusreg.ownername)" style="width:97%;">
    </div>
    <div class="form-group">
      <label for="numberplate">Bus Number Plate</label>
      <input type="text" class="form-control" id="numberplate" placeholder="Enter bus Number Plate" data-ng-model="singlebusreg.busnumberplate" ng-blur="validations('plate',singlebusreg.busnumberplate)" style="width:97%;">
    </div>
     <div class="form-group">
      <label for="mobileno">Mobile No</label>
      <input type="number" class="form-control" step="1" id="mobileno" data-ng-model="singlebusreg.mobileno" placeholder="Enter Mobile No" ng-blur="validations('mobile',singlebusreg.mobileno)" style="width:97%;">
    </div>
    <div class="form-group">
      <label for="email">Email ID</label>
      <input type="email" class="form-control" id="email" data-ng-model="singlebusreg.emailid" placeholder="Enter Email ID" ng-blur="validations('email',singlebusreg.emailid)" style="width:97%;">
    </div>
    <br>
   </div>
    
    <h1 class="verticaltabs" data-ng-click="expand('busdetails')"><span class="glyphicon glyphicon-plus" ng-show="!expansion2"></span><span class="glyphicon glyphicon-minus" ng-show="expansion2"></span> Bus Details</h1><br>
    <div class="container" ng-show="expansion2">
    <div class="form-group">
      <label for="totalseats">Total No of seats</label>
      <input class="form-control" type="number" ng-click="seatclick()" step="1" id="totalseats" data-ng-model="singlebusreg.seats" ng-blur="validations('seats',singlebusreg.seats)" style="width:97%;" placeholder="10-60">
    </div>
    <div class="form-group">
      <label for="leftseat">No of seats in left side of a single row</label>
      <select style="width:97%;" ng-model="singlebusreg.seatleftside" ng-options="x for x in lisseats" class="form-control" ng-disabled="singlebusreg.seats==null" ng-change="validations('lseat',singlebusreg.seatleftside)"></select>
    </div>
    <div class="form-group">
      <label for="rightseat">No of seats in right side of a single row</label>
      <select style="width:97%;" ng-model="singlebusreg.seatrightside" ng-options="x for x in lisseats" class="form-control" ng-disabled="singlebusreg.seats==null" ng-change="validations('rseat',singlebusreg.seatrightside)"></select>
    </div>
    <div class="form-group">
      <label for="lastseat">No of seats in last row</label>
      <select style="width:97%;" ng-model="singlebusreg.seatlastseat" ng-options="x for x in lisbackseats" class="form-control" ng-disabled="singlebusreg.seats==null" ng-change="validations('lastseat',singlebusreg.seatlastside)"></select>
    </div>
    <div class="form-group">
      <label for="totalrows">Total No of rows</label>
      <input class="form-control" type="number" id="totalrows" data-ng-model="singlebusreg.rows" ng-disabled="true" style="width:97%;">
    </div>
    <br>
    </div>
    
   <h1 class="verticaltabs" data-ng-click="expand('stoppagedetails')"><span class="glyphicon glyphicon-plus" ng-show="!expansion3"></span><span class="glyphicon glyphicon-minus" ng-show="expansion3"></span> Trip Details</h1><br> 
    <div class="container" ng-show="expansion3">
    <div class="form-group">
      <label for="endpoint1">End Point 1</label>
      <input class="form-control" type="text" id="endpoint1" data-ng-model="singlebusreg.endpoint1" ng-blur="validations('endpoint1',singlebusreg.endpoint1)" style="width:97%;" placeholder="Enter Location Name">
    </div>
    <div class="form-group">
      <label for="endpoint2">End Point 2</label>
      <input class="form-control" type="text" id="endpoint2" data-ng-model="singlebusreg.endpoint2" ng-blur="validations('endpoint2',singlebusreg.endpoint2)" style="width:97%;" placeholder="Enter Location Name">
    </div>
	<div class="form-group">
    <label>Estimated Hour</label>
    <input type="number" class="form-control" data-ng-model="singlebusreg.esthr" step="1" ng-blur="validations('esthr',singlebusreg.esthr)" style="width:97%;" placeholder="0-23">
	</div> 
	<div class="form-group">
    <label>Estimated Minute</label> 
    <input type="number" class="form-control" data-ng-model="singlebusreg.estmin" step="1" ng-blur="validations('estmin',singlebusreg.estmin)" style="width:97%;" placeholder="0-59">
	</div> 
    <div class="form-group">
      <label for="nostoppages">No of Stoppages(Including Endpoints)</label>
      <input class="form-control" type="number" step="1" id="nostoppages" data-ng-model="singlebusreg.nostoppages" ng-blur="validations('stoppagesno',singlebusreg.nostoppages)" style="width:97%;" placeholder="2-10">
    </div>
    <br>
    </div>
    
    <h1 class="verticaltabs" data-ng-click="expand('stoppages')"><span class="glyphicon glyphicon-plus" ng-show="!expansion4"></span><span class="glyphicon glyphicon-minus" ng-show="expansion4"></span> Stoppages Details</h1><br> 
    <div class="container" ng-show="expansion4">
	    <div class="input-group mb-3" ng-show="singlebusreg.nostoppages!=null">
	    <label>Stoppages(Including Endpoints)</label>
	    <input data-ng-repeat="m in stoppagelis" type="text" class="form-control" placeholder="Stoppage Name" data-ng-model="m.locname" ng-blur="validations('stoppages',m)" ng-disabled="m.disable" style="width:97%;">
	   	</div>
	   	<div ng-show="singlebusreg.nostoppages==null">
	   	<p>Please fill No of Stoppages First</p>
	   	</div>
   	</div>
    <br>
    <div class="d-flex justify-content-center">
    <button type="button" ng-click="busregsubmit()" class="btn btn-success">Submit</button>
    &nbsp;
    <button type="button" ng-click="reset()" class="btn btn-success">Reset</button>
    </div>
  </form>
</div>