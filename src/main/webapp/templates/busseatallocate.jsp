<div class="container">
<h5 class="clear1">&nbsp;</h5>

<div class="custbook1">
<table>
<tr>
<td data-ng-repeat="m1 in m.backseatdtls"><div class="custbook2" data-ng-click="selectseat(m,m1)" style="background-color:{{m1.color}};"></div></td>
</tr>
<tr data-ng-repeat="m2 in m.rowseatdtls">
<td data-ng-repeat="m3 in m2"><div class="custbook2" data-ng-click="selectseat(m,m3)" style="background-color:{{m3.color}};"></div></td>
</tr>
</table>
</div>


<div class="custbook3">
<form>
<div class="form-group">
    <label>Customer Name</label>
    <input type="text" class="form-control" style="width:300px" data-ng-model="m.resp.custdtls.cstmrname" data-ng-blur="validatecust('name',m)">
</div>
<div class="form-group">
    <label>Email ID</label>
    <input type="email" class="form-control" style="width:300px" data-ng-model="m.resp.custdtls.emailid" data-ng-blur="validatecust('email',m)">
</div>
<div class="form-group">
    <label>Phone No</label>
    <input type="number" step="1" class="form-control" style="width:300px" data-ng-model="m.resp.custdtls.mobileno" data-ng-blur="validatecust('number',m)">
</div> 
<div class="form-group">
    <label>Selected Seat No</label>
    <input type="text" class="form-control" style="width:300px" data-ng-model="m.selseats" ng-disabled="true">
</div> 
<div class="d-flex justify-content-center">        
<button type="button" data-ng-click="allocationsubmit(m)" class="btn btn-success">Submit</button> 
&nbsp;
<button type="button" data-ng-click="expandbus(m,'refresh')" class="btn btn-success">Refresh</button> 
</div>
</form>
</div>
<h5 class="clear1">&nbsp;</h5>
</div>