<div>
<div ng-show="viewschtrips.length==0" style="margin-left:2%;margin-right:2%;">
<h4>No Details Found.Please Try Again Later.</h4>
</div> 
<div style="margin-left:2%;margin-right:2%;background-color:Ivory;" ng-show="viewschtrips.length>0">         
  <table class="table table-bordered">
    <thead style="background-color:#0066b2;">
      <tr>
        <th class="text-center">Start Point</th>
        <th class="text-center">End Point</th>
        <th class="text-center">Departure Date</th>
        <th class="text-center">Departure Time</th>
        <th class="text-center">Arrival Date</th>
        <th class="text-center">Arrival Time</th>
        <th class="text-center">Seat Pdf</th>
      </tr>
    </thead>
    <tbody class="text-center">
      <tr data-ng-repeat="m in viewschtrips">
        <td>{{m.startpoint}}</td>
        <td>{{m.endpoint}}</td>
        <td>{{m.depdate}}</td>
        <td>{{m.deptime}}</td>
        <td>{{m.arrdate}}</td>
        <td>{{m.arrtime}}</td>
        <td><a href="http://localhost:8080/fetchpdf/{{m.buschid}}">View Pdf</a></td>
      </tr>
    </tbody>
  </table>
</div>
<br>
</div>