import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { Subject } from 'rxjs';
import { ContributionService } from 'src/app/services/contribution.service';
import { VolunteersService } from 'src/app/services/volunteers.service';
import { volunteer } from '../../interfaces/volunteer';
import { Stock } from '../../interfaces/stock';
import { DonateService } from 'src/app/services/donate.service';
import { DatePipe } from '@angular/common';

interface VolunteersValues {
  name: string;
  code: string;
}

interface IteemsValues {
  name1: number;
  code1: number;
}

@Component({
  selector: 'app-create-contribution',
  templateUrl: './create-contribution.component.html',
  styleUrls: ['./create-contribution.component.scss']
})
export class CreateContributionComponent implements OnInit  {
  private unSub$ = new Subject<void>();
  allVolunteers: Array<volunteer> = [];
  allItems: Array<Stock> = [];

  ContributionForm!: FormGroup;
  isLoading: boolean = false;
  erromessages: Array<string> = [];

  VolunteersNames!: VolunteersValues[];
  ItemsIds!: IteemsValues[];

  constructor(
    private fb: FormBuilder,
    private donateService: DonateService,
    private ContributionService: ContributionService,
    private VolunteersService: VolunteersService,
    private router: Router,
    private datePipe: DatePipe
  ) {
    this.createForm();
  }

  ngOnInit() {
    this.getAllVolunteers();
    this.getAllItems();
  }

  getAllVolunteers() {
    this.VolunteersService.getAllVolunteers().subscribe(
      (res: volunteer[]) => {
        this.allVolunteers = res;
        this.VolunteersNames = this.allVolunteers.map((volunteer) => {
          return { name: volunteer.username, code: volunteer.username };
        });
        console.log("All volunteers", res);
        console.log("VolunteersNames", this.VolunteersNames);
      },
      (error) => {
        console.error('Error loading all volunteers:', error);
      }
    );
  }

  getAllItems() {
    this.donateService.getAllDonations().subscribe(
      (res: Stock[]) => {
        this.allItems = res;
        this.ItemsIds = this.allItems.map((item) => {
          return {
            name1: item.id !== undefined ? Number(item.id) : 0,
            code1: item.id !== undefined ? Number(item.id) : 0,
          };
        });
        console.log("All items", res);
        console.log("ItemsIds", this.ItemsIds);
      },
      (error) => {
        console.error('Error loading all items:', error);
      }
    );
  }

  createForm() {
    this.ContributionForm = this.fb.group({
      name: ['', Validators.required],
      departureDate: ['', Validators.required],
      departureCity: ['', Validators.required],
      vehicle: ['', Validators.required],
      city: ['', Validators.required],
      volunteerUsernames: ['', Validators.required],
      itemIds: ['', Validators.required],
    });
  }

  formatToBackendDate(date: Date): string {
    return this.datePipe.transform(date, 'yyyy-MM-dd') || '';
  }

  save() {
    console.log('ContributionForm:', this.ContributionForm.value);
    
    if (this.ContributionForm.valid) {
      this.isLoading = true;

      // Récupérez les valeurs du formulaire
      const formValues = this.ContributionForm.value;

      // Formatez les dates en utilisant DatePipe
      const formattedData = {
        ...formValues,
        departureDate: this.formatToBackendDate(formValues.departureDate),
      };

      // Appelez le service pour effectuer la requête
      this.ContributionService.contibutionSave(formattedData).subscribe(
        (res) => {
          console.log("DonateBloodForm Res:", res);

          this.ContributionService.sendMessage('task saved ');
           this.router.navigate(['../contribution']);

          // Effectuez les opérations nécessaires après la sauvegarde réussie ici
        },
        (error) => {
          this.isLoading = false;
          this.erromessages = error.error.validationErrors;
          console.error('Error saving donation', error);

          // Ajoutez ici la logique de gestion des erreurs spécifique
        }
      );
    }
  }
}
