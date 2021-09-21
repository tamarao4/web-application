import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PravoPristupaFormComponent } from './pravo-pristupa-form.component';

describe('PravoPristupaFormComponent', () => {
  let component: PravoPristupaFormComponent;
  let fixture: ComponentFixture<PravoPristupaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PravoPristupaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PravoPristupaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
