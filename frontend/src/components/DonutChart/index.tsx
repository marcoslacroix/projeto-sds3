import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChar = () => {

    const [chartData, setChartData] = useState<ChartData>(
        {
            labels: [],
            series: []
        }
    );

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/amount-grouped-by-seller`)
        .then(resp => {
            const data = resp.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeriess = data.map(x => x.sum);
            setChartData({
                labels: myLabels,
                series: mySeriess
            });        
        })
    },[])

  //  const mockData = {
   //     series: [477138, 499928, 444867, 220426, 473088],
     //   labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
  //  }
    
    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{...options, labels: chartData.labels}}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}
export default DonutChar;


